/**
 * 
 */
package com.ccsoft.springBatchMongo.daomongo.impl;

import com.ccsoft.springBatchMongo.entity.LogInfoMd;
import com.ccsoft.springBatchMongo.util.Page;
import com.ccsoft.springBatchMongo.daomongo.LogInfoDaoMd;
import com.ccsoft.springBatchMongo.daomongo.basedao.MongoDBBaseDao;
import com.ccsoft.springBatchMongo.util.Grid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;


/**
 * TODO 日志信息Dao实现类 MongoDb
 * @date 2015年11月12日
 * @author huangyongchao
 */
@Service(value = "logInfoDaoMd")
public class LogInfoDaoMdImpl   extends MongoDBBaseDao<LogInfoMd> implements LogInfoDaoMd {

        
        
        /**
         * TODO
         * @date 2015年11月12日
         * @author huangyongchao
         * @param
         * @return
         * @throws
        */
        @Override
        protected Class<LogInfoMd> getEntityClass() {

                return LogInfoMd.class;
        }

        /**
         * TODO 实现MongoTemplate 的注入给父类
         * @date 2015年11月12日
         * @author huangyongchao
         * @param MongoTemplate
         * @return
         * @throws
        */
        @Autowired
        @Qualifier("mongoTemplate")
        @Override
        protected void setMongoTemplate(MongoTemplate mongoTemplate) {
                super.mongoTemplate = mongoTemplate;
        }

        /**
         * TODO 按条件查找并且分页
         * @date 2015年11月12日
         * @author huangyongchao
         * @param
         * @return
         * @throws
         */
        @Override
        public Grid selectByCondiions(Map<String, Object> map,int pageNo,int rows) {
                Query query =  new Query();
                

                String  message =  map.get("message") ==null?"":map.get("message")+"";
                String  hostname =  map.get("hostname") ==null?"":map.get("hostname")+"";
                String  classname =  map.get("classname") ==null?"":map.get("classname")+"";
                String  methodname =  map.get("methodname") ==null?"":map.get("methodname")+"";
                String  timestampstart =  map.get("timestampstart") ==null?"":map.get("timestampstart")+"";
                String  timestampend =  map.get("timestampend") ==null?"":map.get("timestampend")+"";
                Criteria crs = new Criteria();
                crs = crs.where("message").regex(message)
                .and("host.name").regex(hostname)
                .and("method").regex(methodname)
                .and("class.fullyQualifiedClassName").regex(classname);
                
                SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                
                try {
                        if(!"".equals(timestampstart)&&"".equals(timestampend)){
                                crs = crs.and("timestamp").gte(fmt.parse(timestampstart));
                        }
                        if(!"".equals(timestampend)&&"".equals(timestampstart)){
                                crs = crs.and("timestamp").lte(fmt.parse(timestampend));
                        }
                        if(!"".equals(timestampend)&&!"".equals(timestampstart)){
                                crs = crs.and("timestamp").gte(fmt.parse(timestampstart)).lte(fmt.parse(timestampend));
                        }
                } catch (ParseException e) {
                        e.printStackTrace();
                }
                query.addCriteria(crs);
                System.out.println("---mongo 查询条件 ---"+query.toString());
                Page<LogInfoMd> page = this.getPage(pageNo, rows, query);
                Grid grid = new Grid();
                grid.setRows(page.getDatas());
                grid.setTotal(page.getTotalCount());
                
                return grid;
        }

     
        /**
         * TODO 删除数据根据ID集合
         * @date 2015年11月12日
         * @author huangyongchao
         * @param
         * @return
         * @throws
         */
        @Override
        public void deleteByIdList(String[] idlists) {
                for(String id : idlists){
                        Criteria crs = new Criteria();
                        Query query =  new Query();
                        query.addCriteria(crs.where("_id").is(new ObjectId(id)));
                        this.findAndRemove(query);
                }
        }

}
