package com.bing.resume.framework.web.handler;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.bing.resume.framework.exception.BaseException;

public class MvcErrorHandler implements HandlerExceptionResolver {
	
	/**
	 * logger
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 错误前缀
	 */
	private static final String ERRKEY_PREFIX = "error.";
	
	/**
	 * 位置错误
	 */
	private static final String UNKOWN_ERROR="1000";
	
	private static final String ERROR_CODE = "rspCode";
	
	private static final String ERROR_MESSAGE = "rspMsg";
	
	/**
	 * ajax请求错误信息
	 */
	public static final String ERR_RESPONSE_DATA = "responseData";

	private ResourceBundleMessageSource messageSource;
	
	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse res, Object obj, Exception e) {
		if (null != e) {
			if (e instanceof BaseException) {// 自定义错误
				BaseException baseErr = (BaseException) e;
				String errMsg = messageSource.getMessage(baseErr.getErrorCode(), baseErr.getArgs(), null);
				
				logger.error("errcode:{};errmsg:{}",baseErr.getErrorCode(), errMsg, e);
				return viewDispatcher(req, obj, baseErr.getErrorCode(), errMsg);
			}else if(e instanceof DataIntegrityViolationException){
				logger.error("uenpay unkown excpetion occured:", e);
				return viewDispatcher(req, obj, UNKOWN_ERROR, "数据库数据完整性异常");
			}
		}
		// 未知错误
		logger.error("uenpay unkown excpetion occured:", e);
		String errMsg = messageSource.getMessage(ERRKEY_PREFIX
				+ UNKOWN_ERROR, null, null);
		return viewDispatcher(req, obj, UNKOWN_ERROR, errMsg);
	}
	
	/**
	 * 视图分发
	 */
	private ModelAndView viewDispatcher(HttpServletRequest req,Object obj,String errCode, String errMsg){
		HandlerMethod handlerMethod = (HandlerMethod) obj;
		Method controllerMethod = handlerMethod.getMethod();
		ResponseBody annotationClass = controllerMethod.getAnnotation(ResponseBody.class);		
		// 返回视图使用跳转
		if (null == annotationClass) {
			return ModelAndViewPage(errCode, errMsg);
		}else{
			return ModelAndViewJson(req, handlerMethod, errCode, errMsg);
		}
		
	}
	
	/**
	 * 页面错误信息
	 * @param errCode
	 * @param errMsg
	 * @return
	 */
	private ModelAndView ModelAndViewPage(String errCode, String errMsg){
		ModelAndView view = new ModelAndView("error/error");
		view.addObject(ERROR_CODE, errCode);
		view.addObject(ERROR_MESSAGE, errMsg);
		return view;
	}
	
	/**
	 * 返回json错误数据
	 */
	private ModelAndView ModelAndViewJson(HttpServletRequest req, HandlerMethod handlerMethod, String errCode, String errMsg){
		ModelAndView view = new ModelAndView("forward:/common/ajaxErrRes");	
		ResponseData responseData = new ResponseData(errCode, errMsg);
		responseData.setStatus(1);
		req.setAttribute(ERR_RESPONSE_DATA, responseData);
		return view;
	}

}
