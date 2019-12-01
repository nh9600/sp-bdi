package com.sp.bdi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
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
		for (int i = 1; i <= 10; i++) {
			list.add("name" + i);
		}
	}

	@RequestMapping(value = "/ajax", method = RequestMethod.GET)
	public @ResponseBody List<String> getAjax(@RequestParam Map<String, String> map) {
		log.debug("param : {}", map);
		String searchName = map.get("searchName");
		for (String str : this.list) {
			if(str.indexOf(searchName)!=-1) {
				list.add(searchName);
			}
		}
		return list;

	}

}
