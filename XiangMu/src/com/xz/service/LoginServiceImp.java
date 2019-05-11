package com.xz.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.xz.dao.LoginMapper;
import com.xz.entity.Role;
import com.xz.entity.User;
import com.xz.entity.UserRole;
import com.xz.fujie.MD5Util;

@Service
public class LoginServiceImp implements LoginService {
     @Resource
	private LoginMapper loginMapper;
     @Resource
	  private UserService userService;
	@Override
	public Integer loginError(User user, String yanzhengma, HttpServletRequest request) {
		// TODO Auto-generated method stub
		int jg=0;
		if(request.getSession().getAttribute("text").equals(yanzhengma)) {
			if(loginMapper.selectIs(user.getU_loginName())==1) {
				user.setU_password(MD5Util.string2MD5(user.getU_password()));
				user = loginMapper.selectUs(user);
				if(user!=null) {
					if(user.getU_isLockout()==0) {
						/* List<UserRole> selectJuese = loginMapper.selectByuId(user.getU_id()); */
						User user2=new User();
						Date date=new Date();
						SimpleDateFormat format=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
						String format2 = format.format(date);
						user2.setU_lastLoginTime(format2);
						user2.setU_id(user.getU_id());
						userService.updateLastTime(user2);
						/*
						 * for(int i=0;i<selectJuese.size();i++) { List<Mokuai> selectMokuai =
						 * mainMapper.selectMokuai(selectJuese.get(i).getJs_id());
						 * selectJuese.get(i).setMokuai(selectMokuai); } user.setJuese(selectJuese);
						 */
						request.getSession().setAttribute("user", user);
					}else {
						jg=4;
					}
				}else {
					jg=3;
				}
			}else {
				jg=2;
			}
		}else {
			jg=1;
		}
		return jg;
	}

}
