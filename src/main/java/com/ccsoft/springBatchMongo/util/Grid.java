package com.ccsoft.springBatchMongo.util;

import java.util.ArrayList;
import java.util.List;

/**
  * TODO 分页展示给EASYUI 的bean
  * @date 2015年11月12日
  * @author huangyongchao
 */
public class Grid implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long total = 0L;
	@SuppressWarnings("rawtypes")
	private List rows = new ArrayList();

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	@SuppressWarnings("rawtypes")
	public List getRows() {
		return rows;
	}

	@SuppressWarnings("rawtypes")
	public void setRows(List rows) {
		this.rows = rows;
	}

}
