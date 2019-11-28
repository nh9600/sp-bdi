package com.sp.bdi.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sp.bdi.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {
	@RequestMapping(value="/test",method = RequestMethod.GET)
	public @ResponseBody Map<String, String> test() {
		Map<String, String> rMap = new HashMap<String, String>();
		return rMap;
	}
	@RequestMapping(value="/test1",method = RequestMethod.POST)
	public @ResponseBody Map<String, String> test1(@RequestParam Map<String,String> param) {
		log.debug("param:{}",param);
		Map<String, String> rMap = new HashMap<String, String>();
		rMap.put("key","난 test1");
		return rMap;
	}
}
