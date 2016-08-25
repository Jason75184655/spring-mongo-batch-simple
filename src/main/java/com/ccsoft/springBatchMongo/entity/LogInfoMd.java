package com.ccsoft.springBatchMongo.entity;

import com.mongodb.BasicDBObject;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
//映射
@Document(collection="error_log")
public class LogInfoMd implements Serializable{
	private static final long serialVersionUID = -2767742790675928589L;
	/*
	 * 日志信息id
	 * */
	//private ObjectId  _id;
	private String  _id;
	/*
	 * 日志信息生成时间
	 * */
	private String timestamp;
	/*
	 * 日志级别
	 * */
	private String level;
	/*
	 * 线程
	 * */
	private String thread;
	/*
	 * 日志信息
	 * */
	private String message;
	/*
	 * 包名
	 * */
	private BasicDBObject loggerName;
	/*
	 * 程序文件名
	 * */
	private String fileName;
	/*
	 * 日志输出方法名
	 * */
	private String method;
	/*
	 * 产生日志信息行号
	 * */
	private String lineNumber;
	/*
	 * 类信息
	 * */
	@Field("class")
	private BasicDBObject _class;
	/*
	 * 服务器信息
	 * */
	private BasicDBObject host;
	/*
	 * 日志参数信息
	 * */
	private String params;
 
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public BasicDBObject getLoggerName() {
		return loggerName;
	}
	public void setLoggerName(BasicDBObject loggerName) {
		this.loggerName = loggerName;
	}
	public BasicDBObject getHost() {
		return host;
	}
	public void setHost(BasicDBObject host) {
		this.host = host;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
        
        
        public String getThread() {
        
                return thread;
        }
        
        public void setThread(String thread) {
        
                this.thread = thread;
        }
        public BasicDBObject get_class() {
        
                return _class;
        }
        
        public void set_class(BasicDBObject _class) {
        
                this._class = _class;
        }
}
