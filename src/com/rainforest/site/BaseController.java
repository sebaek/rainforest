package com.rainforest.site;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("/") 
public class BaseController {
	
	@Inject
	BaseService baseService;

	@RequestMapping(value="hello", method=RequestMethod.GET)
	public String hello() {
		
		return "hello";
		
	}
	
	@RequestMapping(value="match", method=RequestMethod.POST) 
	public String match() {
		baseService.match();
		return "match";
	}
	

}
