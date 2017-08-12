package com.bing.resume.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bing.resume.framework.web.handler.MvcErrorHandler;
import com.bing.resume.framework.web.handler.ResponseData;

@Controller
@RequestMapping("common")
public class CommonController {

	@RequestMapping(value="/ajaxErrRes")
	public @ResponseBody ResponseData errAjaxResponse(HttpServletRequest req){
		ResponseData errData = (ResponseData)req.getAttribute(MvcErrorHandler.ERR_RESPONSE_DATA);
		return errData;
	}
}
