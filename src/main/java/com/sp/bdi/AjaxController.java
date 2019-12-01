package com.sp.bdi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AjaxController {
	private List<String> list = new ArrayList<String>();
	public AjaxController() {
		for(int i=1;i<=10;i++) {
			list.add("name"+ i);
		}
	}
	@RequestMapping(value="/ajax",method=RequestMethod.GET)
	public @ResponseBody Map<String,String> getAjax(@RequestParam Map<String,String> map) {
		log.debug("param=>{}",map);
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("greeting","hello");
		return rMap;
	}
	
	@RequestMapping(value="/ajax",method=RequestMethod.POST)
	public @ResponseBody Map<String,String> postAjax(@RequestParam Map<String,String> map) {
		log.debug("param=>{}",map);
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("greeting","hello");
		return rMap;
	}
	
	@RequestMapping(value="/ajax/json",method=RequestMethod.POST)
	public @ResponseBody Map<String,String> postJson(@RequestBody Map<String,String> map) {
		log.debug("param=>{}",map);
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("greeting","hello");
		return rMap;
	}
}
