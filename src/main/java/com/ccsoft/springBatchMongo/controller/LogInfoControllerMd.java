package com.ccsoft.springBatchMongo.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccsoft.springBatchMongo.service.LogInfoServiceMd;
import com.ccsoft.springBatchMongo.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ccsoft.springBatchMongo.util.Grid;
import com.ccsoft.springBatchMongo.util.ResponseUtil;

/**
  * TODO LogInfo MONGODB 错误日志控制器
  * @date 2015年11月11日
  * @author huangyongchao
 */
@Controller
@RequestMapping("/loginfomd")
public class LogInfoControllerMd {
	@Resource
	private LogInfoServiceMd logInfoServiceMd;
	
	/**
	 * TODO 跳转到MYSQL错误日志查询界面
	 * @date 2015年11月11日
	 * @author huangyongchao
	 * @return String
	 * @throws
	 */
	@RequestMapping("/loglist")
	public String loglist(HttpServletRequest request){
		return "errorLogListMd";
	}
	
        
        /**
         * 
         * TODO
         * @date 2015年11月11日
         * @author huangyongchao
         * @return
         * @throws
         */
        @RequestMapping("/queryLogByConditions")
        public void queryLogByConditionsMd(@RequestParam Map<String,Object> map ,int page ,int rows ,HttpServletRequest request,HttpServletResponse response){

                Grid grid =logInfoServiceMd.selectByCondiions(map,page,rows); // 分页的pagebean
                ResponseUtil.responseText(response, JSON.toJSONString(grid));

        }
        
        /**
         * TODO 根据ID数组删除数据
         * @date 2015年11月12日
         * @author huangyongchao
         * @return
         * @throws
         */
        @RequestMapping("/deleteByIdList")
        public void deleteByIdList(String ids,HttpServletRequest request,HttpServletResponse response){
                JSONObject json = new JSONObject();
                try {
                        String[] idlists = ids.split(",");
                        logInfoServiceMd.deleteByIdList(idlists);
                        json.put(ConstantUtil.STATUS, ConstantUtil.SUCCESS);
                        json.put(ConstantUtil.MESSAGE, "删除成功");
                } catch (Exception e) {
                        
                        json.put(ConstantUtil.STATUS, ConstantUtil.FAIL);
                        json.put(ConstantUtil.MESSAGE, "删除失败");
                }
                ResponseUtil.responseText(response, JSON.toJSONString(json));
                
                
        }
        
        
}
