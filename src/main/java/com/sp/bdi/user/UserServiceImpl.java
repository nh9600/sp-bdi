package com.sp.bdi.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public List<Map<String, String>> getUserList() {
		return userDAO.selectUserList();
	}

	@Override
	public List<UserVO> getUserVOList(UserVO param) {
		return userDAO.selectUserVOList(param);
	}

	@Override
	public Map<String, String> insertUserInfo(UserVO user) {
		Map<String, String> rMap = new HashMap<String, String>();
		rMap.put("cnt", userDAO.insertUserInfo(user) + "");
		return rMap;
	}

	@Override
	public Map<String, String> updateUserInfo(UserVO user) {
		Map<String, String> rMap = new HashMap<String, String>();
		rMap.put("cnt", userDAO.updateUserInfo(user) + "");
		return rMap;
	}

	@Override
	public Map<String, String> deleteUserInfo(UserVO user) {
		Map<String, String> rMap = new HashMap<String, String>();
		rMap.put("cnt", userDAO.deleteUserInfo(user) + "");
		return rMap;
	}

	@Override
	public UserVO getUserVO(UserVO user) {
		return userDAO.selectUserInfo(user);
	}

	@Override
	public UserVO login(UserVO user) {
		return userDAO.selectUser(user);
	}

}
