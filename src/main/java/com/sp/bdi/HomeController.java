package com.sp.bdi;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@Controller //context:component-scan base-package="com.sp.bdi"폴더 아래 있는 모든 컨트롤러를 읽어! 이렇게해서 메모리 생성
//base-package 밖에 만들면 @Controller 안먹음
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );//시간 바뀌는 걸 넣고 
		List<String> strList = new ArrayList<String>();
		strList.add("나는 박하늘");
		strList.add("젤리");
		strList.add("월요일");
		strList.add("피곤");
		model.addAttribute("strList",strList);
		
		return "home";// /WEB-INF/views/home.jsp 스트링으로 맞춰주면 됨
	}
	
	@RequestMapping(value="/test/t1")
	public String test(Model m) {
		// /WEB-INF/views/test/test.jsp
		System.out.println(m);// 결과 {}가 나왔다는건 어디선가 new를 해서 메모리를 생성했다는 것!
		return "test/test";
	}
	
}
