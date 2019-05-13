package com.xz.service;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import com.xz.entity.User;

public interface MainService {
	String hometree(String treeUlId,HttpServletRequest requer);
	
	Integer empqd(User user) throws ParseException;
}
