package com.xz.service;

import javax.servlet.http.HttpServletRequest;

import com.xz.entity.User;

public interface LoginService {
	/**
	 * ���е�¼��֤
	 * @param user
	 * @param yanzhengma
	 * @param request
	 * @return
	 */
Integer loginError(User user, String yanzhengma, HttpServletRequest request);

Integer forgetPassword(User user,HttpServletRequest request);
}
