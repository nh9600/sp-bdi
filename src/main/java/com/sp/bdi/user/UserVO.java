package com.sp.bdi.user;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("user")
@Data
public class UserVO {
	private String uiName;
	private String active;
	private String uiId;
	private String uiPwd;
	private String moddat;
	private String modtim;
	private String credat;
	private String cretim;
	private Integer uiNum;
	private String[] search;
	private String searchStr;
}
