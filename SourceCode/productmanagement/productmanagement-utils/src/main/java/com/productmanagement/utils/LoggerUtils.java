package com.productmanagement.utils;

import org.apache.log4j.Logger;

public class LoggerUtils {

	private static Logger logger = Logger.getLogger(LoggerUtils.class);
	private String className;
	
	private LoggerUtils(){
		
	}
	
	/**
	 * Constructor
	 * @param className
	 */
	public LoggerUtils(Class className){
		LoggerUtils customLogger = null;
		try {
			customLogger = new LoggerUtils();
			customLogger.setClassName(className.getName());
		} catch (Exception e) {
			logger.fatal("Exception in Logger config", e);
		}
	}
	
	private String getClassName() {
		return className;
	}

	private void setClassName(String className) {
		this.className = className;
	}
	
	/**
	 * method to log a message with throwable;
	 * @param message
	 * @param t
	 */
	public void log(String message,Throwable t){
		if(logger.isDebugEnabled()){
			logger.debug(message, t);
		} else if(logger.isInfoEnabled()){
			logger.info(message, t);
		} else if(logger.isTraceEnabled()){
			logger.trace(message, t);
		} else {
			logger.error(message, t);
		}
	}
	
	/**
	 * method to log a message.
	 * @param message
	 */
	public void log(String message){
		if(logger.isDebugEnabled()){
			logger.debug(message);
		} else if(logger.isInfoEnabled()){
			logger.info(message);
		} else if(logger.isTraceEnabled()){
			logger.trace(message);
		} else {
			logger.error(message);
		}
	}

	

}
