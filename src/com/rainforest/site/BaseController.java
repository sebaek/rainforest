package com.rainforest.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/") 
public class BaseController {

	@RequestMapping(value="hello")
	public String hello() {
		
		return "hello";
		
	}
	
	@RequestMapping 
	public String match() {
		return "match";
	}
	

}
