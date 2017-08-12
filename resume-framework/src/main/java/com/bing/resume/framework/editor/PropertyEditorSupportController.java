package com.bing.resume.framework.editor;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class PropertyEditorSupportController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {	
		//自动转换日期类型的字段格式
		binder.registerCustomEditor(java.util.Date.class, new DatePropertyEditorSupport());	
	}
}
