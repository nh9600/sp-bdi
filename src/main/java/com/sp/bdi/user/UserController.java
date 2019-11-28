package com.sp.bdi.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService us;
	
	@RequestMapping("/user/list")
	public String getUserList(Model model) {
		model.addAttribute("userList",us.getUserList());
		return "user/list";
	}
	
	@RequestMapping(value="/user/list/ajax",method=RequestMethod.GET)//조회
	public @ResponseBody List<UserVO> getUserList(@ModelAttribute UserVO param){
		log.debug("param:{}",param);
		return us.getUserVOList(param);
	}
	
	@RequestMapping(value="/user/list/view",method=RequestMethod.GET)//조회
	public @ResponseBody UserVO getUser(@ModelAttribute UserVO user){
		log.debug("user:{}",user);
		return us.getUserVO(user);
	}
	
	@RequestMapping(value="/user/list/signup",method=RequestMethod.POST)//삽입
	public @ResponseBody Map<String,String> insertUser(@RequestBody UserVO user){
		log.debug("user:{}",user);
		return us.insertUserInfo(user);
	}
	
	@RequestMapping(value="/user/list/ajax",method=RequestMethod.PUT)//수정
	public @ResponseBody Map<String,String> updateUser(@RequestBody UserVO user){
		log.debug("user:{}",user);
		return us.updateUserInfo(user);
	}
	
	@RequestMapping(value="/user/list/ajax",method=RequestMethod.DELETE)//삭제
	public @ResponseBody Map<String,String> deleteUser(@RequestBody UserVO user){
		log.debug("user:{}",user);
		return us.deleteUserInfo(user);
	}
}
