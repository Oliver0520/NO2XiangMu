package com.xz.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.xz.dao.LoginMapper;
import com.xz.entity.Module;
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
     @Resource
     private Role role;
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
						
						User user2=new User();
						Date date=new Date();
						SimpleDateFormat format=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
						String format2 = format.format(date);
						user2.setU_lastLoginTime(format2);
						user2.setU_id(user.getU_id());
						userService.updateLastTime(user2);
						 List<Role> selectJuese = loginMapper.selectByuId(user.getU_id()); 
						
						  for(int i=0;i<selectJuese.size();i++) { 
					List<Module> selectMokuai = loginMapper.selectMokuai(selectJuese.get(i).getR_id());
					selectJuese.get(i).setModule(selectMokuai); } 
						  user.setRole(selectJuese);
						request.getSession().setAttribute("usera", user);
						Integer qdstatus=user.getU_qdstatus();
						request.getSession().setAttribute("qdstatus", qdstatus);
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
