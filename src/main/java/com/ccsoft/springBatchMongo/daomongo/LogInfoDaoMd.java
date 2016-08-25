package com.ccsoft.springBatchMongo.daomongo;


import com.ccsoft.springBatchMongo.util.Grid;

import java.util.Map;


/**
  * TODO 日志信息的Dao MongoDb
  * @date 2015年11月11日
  * @author huangyongchao
 */
public interface LogInfoDaoMd {

        /**
         * TODO 根据条件查询错误日志
         * @date 2015年11月11日
         * @author huangyongchao
         * @return List<LogInfo>
         * @throws
         */
        Grid selectByCondiions(Map<String ,Object> map,int page,int rows);
        
        /**
         * TODO 根据ID数组删除数据
         * @date 2015年11月12日
         * @author huangyongchao
         * @param
         * @return
         * @throws
         */
        void deleteByIdList(String[] idlists );
        
}