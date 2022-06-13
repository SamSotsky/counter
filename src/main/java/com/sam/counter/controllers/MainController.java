package com.sam.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class MainController {

	@RequestMapping("/")
	public String index(HttpSession session){
		if(session.getAttribute("count") == null) {
		session.setAttribute("count", 0);
		}
		Integer countUp =(Integer)session.getAttribute("count")+1;
		session.setAttribute("count", countUp);
		return "index.jsp";
	}
	
	// ...
	@RequestMapping("/showCount")
		public String showCount(HttpSession session, Model model) {
			Integer currentCount = (Integer) session.getAttribute("count");
			model.addAttribute("countToShow", currentCount);
			return "showCount.jsp";
		}
	// ...


}
