package com.xz.service;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import com.xz.entity.User;

public interface MainService {
	String hometree(String treeUlId,HttpServletRequest requer);
	
	Integer empqd(User user) throws ParseException;
	/**
	 * 产生一个随机数
	 * @return
	 */
	String suijiNum(HttpServletRequest request);
	
	Integer empqt(User user) throws ParseException;
}
