package com.sp.bdi.user;

import java.util.List;
import java.util.Map;

public interface UserDAO {
	public List<Map<String, String>> selectUserList();
	public List<UserVO> selectUserVOList(UserVO param);
	public UserVO selectUserInfo(UserVO user);
	public int insertUserInfo(UserVO user);
	public int updateUserInfo(UserVO user);
	public int deleteUserInfo(UserVO user);

}
