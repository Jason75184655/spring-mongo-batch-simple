package com.ccsoft.springBatchMongo.service.impl;

import java.util.Map;

import com.ccsoft.springBatchMongo.service.LogInfoServiceMd;

import com.ccsoft.springBatchMongo.daomongo.LogInfoDaoMd;
import com.ccsoft.springBatchMongo.util.Grid;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
  * TODO日志信息Service
  * @date 2015年11月11日
  * @author huangyongchao
 */
@Service("logInfoServiceMd")
public class LogInfoServiceImplMd implements LogInfoServiceMd {
        @Resource
        private LogInfoDaoMd logInfoDaoMd ;

        /**
         * TODO 根据条件查询日志列表并且分页
         * @date 2015年11月11日
         * @author huangyongchao
         * @param Map<String, Object>
         * @return List<LogInfo>
         * @throws
        */
        @Override
        public Grid selectByCondiions(Map<String, Object> map,int pageNo,int rows) {
                
                return logInfoDaoMd.selectByCondiions(map,pageNo,rows);
        }

        /**
         * TODO 根据ID数组删除数据
         * @date 2015年11月12日
         * @author huangyongchao
         * @param
         * @return
         * @throws
         */
        @Override
        public void deleteByIdList(String[] idlists) {
                logInfoDaoMd.deleteByIdList(idlists);
                
        }



}
