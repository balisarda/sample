package com.mycompany.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

//@Controller로 컨트롤러가 설정되어 있는 부분을 확인
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	/* 
	URL : http://localhost:8080/myapp/WEB-INF/views/home.jsp
	프로토콜 : http
	도메인 주소 : localhost
	사용 포트 : 8080
	사용 서비스 : myapp
	URI : WEB-INF/views/home.jsp
	
	@RequestMapping은 URI를 찾는 것이다.
	*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		logger.info(formattedDate);
		model.addAttribute("serverTime", formattedDate );
		//접속할 페이지 이름(확장자 제외)
		return "home";
	}
	@RequestMapping(value = "/move")
	public String move() {
		
		return "move";
	}
	@RequestMapping(value = "/loginProc")
	public String loginProc() {
		
		return "loginForm";
	}
	@RequestMapping(value = "/myapp")
	public String myapp() {
		
		return "home";
	}
}
