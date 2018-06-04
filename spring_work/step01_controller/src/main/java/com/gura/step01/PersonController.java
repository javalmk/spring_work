package com.gura.step01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 
@Controller
public class PersonController {
	
	//2. 
	@RequestMapping("/person")
	public String person(HttpServletRequest request){
		// 모델(데이터)
		String personToday="김구라";
		// 모델을 request 에 담고
		request.setAttribute("personToday", personToday);
		
		//3. view 페이지로 forward 이동 
		return "person";
	}
}











