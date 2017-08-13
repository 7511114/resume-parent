package com.bing.resume.web.controller.video;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("video")
public class VideoController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private static int count = 0;
	
	@RequestMapping(value="myVideo")
	public String myVideo(Integer id){
		count++;
		logger.info("有多少人访问了该首页：count:{}", count);
		return "videos/video";
	}
}
