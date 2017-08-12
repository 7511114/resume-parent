package com.bing.resume.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@Value("#{globalConfigureProperties['page.title']}") 
	private String pageTitle;

	/**
	 * 主页
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"index",""},method=RequestMethod.GET)
	public String index(Model model,HttpSession session){
		model.addAttribute("page_title", pageTitle);
		return "layout/index";
	}
	
	
}

