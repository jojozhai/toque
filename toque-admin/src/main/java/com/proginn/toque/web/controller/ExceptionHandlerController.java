/**
 * 
 */
package com.proginn.toque.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * @author zhailiang
 *
 */
@ControllerAdvice
public class ExceptionHandlerController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus
	public Map<String, String> handleException(Exception exception) {
		
		logger.info("系统异常:", exception);
		
		String message = exception.getMessage();
		if(exception.getCause() != null) {
			Throwable throwable = exception.getCause().getCause();
			if(throwable != null && throwable instanceof MySQLIntegrityConstraintViolationException){
				if(StringUtils.contains(throwable.getMessage(), "a foreign key constraint fails")){
					message = "无法删除数据,有其它数据依赖此数据";
				}
			}
		}
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("result", "fail");
		result.put("errorMsg", message);
		return result;
		
	}

}
