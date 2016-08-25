package com.ccsoft.springBatchMongo.service;

import java.util.Map;

import com.ccsoft.springBatchMongo.util.Grid;


/**
 * TODO日志信息Service
 * @date 2015年11月11日
 * @author huangyongchao
*/
public interface LogInfoServiceMd {
        
        /**
         * TODO 根据条件查询日志列表
         * @date 2015年11月11日
         * @author huangyongchao
         * @param Map<String ,Object>
         * @return  List<LogInfo> 
         * @throws
         */
        Grid selectByCondiions(Map<String ,Object> map,int pageNo,int rows);
        
        
        /**
         * TODO 根据ID数组删除数据
         * @date 2015年11月12日
         * @author huangyongchao
         * @param
         * @return
         * @throws
         */
        void deleteByIdList(String[] idlists);
        

}
