package com.xz.service;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.xz.dao.UserMapper;
import com.xz.entity.Fenye;
import com.xz.entity.Role;
import com.xz.entity.User;
import com.xz.entity.UserRole;
import com.xz.fujie.MD5Util;
@Service
public class UserServiceImp implements UserService {
     @Resource
	private UserMapper userMapper;
    
	/**
	 * 多条件分页查询用户信息
	 */
	@Override
	public Fenye<User> selectUser(Fenye<User> fenye) {
		// TODO Auto-generated method stub
		
		List<User> rows = userMapper.selectUser(fenye);
		Integer total = userMapper.selectUserCount(fenye);
		fenye.setRows(rows);
		fenye.setTotal(total);
		return fenye;
	}
	@Override
	public Integer selectCountBylname(String u_loginName) {
		// TODO Auto-generated method stub
		return userMapper.selectCountByLname(u_loginName);
	}
	@Override
	public Integer insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertUser(user);
	}
	@Override
	public Integer deleteUser(Integer u_id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUser(u_id);
	}
	@Override
	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}
	@Override
	public Integer chongzhimima(Integer u_id) {
		// TODO Auto-generated method stub
		return userMapper.chongzhimima(u_id);
	}
	@Override
	public Integer suoding(Integer u_id) {
		// TODO Auto-generated method stub
		return userMapper.suoding(u_id);
	}
	@Override
	public Integer jiesuo(Integer u_id) {
		// TODO Auto-generated method stub
		return userMapper.jiesuo(u_id);
	}
	@Override
	public List<Role> selectRole() {
		// TODO Auto-generated method stub
		return userMapper.selectRole();
	}
	@Override
	public List<Role> selectMyRole(Integer u_id) {
		// TODO Auto-generated method stub
		return userMapper.selectMyRole(u_id);
	}
	@Override
	public Integer insertRole(UserRole userRole) {
		// TODO Auto-generated method stub
		return userMapper.addRoles(userRole);
	}
	@Override
	public Integer deleteRole(UserRole userRole) {
		// TODO Auto-generated method stub
		return userMapper.deleteRole(userRole);
	}
	@Override
	public Integer updateLastTime(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateLastTime(user);
	}
	@Override
	public Integer updateMima(User user,HttpServletRequest request) {
		// TODO Auto-generated method stub

   	 user.setOpwd(MD5Util.string2MD5(user.getOpwd()));
   	 user.setApwd(MD5Util.string2MD5(user.getApwd()));   	 
   	 user.setNpwd(MD5Util.string2MD5(user.getNpwd()));
		Integer jg=0;
		User user1 = (User)request.getSession().getAttribute("usera");
		user.setU_id(user1.getU_id());
		String yanzhengma = (String) request.getSession().getAttribute("suijiNum");
		if(user.getYanzheng().equals(yanzhengma)) {
		if(user.getOpwd().equals(user1.getU_password())){
			if(user.getApwd().equals(user.getNpwd())) {
				if(userMapper.updateMima(user)>0) {
					return jg=4;
				}else {
					return jg=3;
				}
			}else {
				return jg=2;
			}
		}else {
			return jg=1;
		}
		}else {
			return jg=5;
		}
		
		
	}
	@Override
	public Fenye<User> selectUserQD(Fenye<User> fenye) {
		// TODO Auto-generated method stub
		List<User> rows = userMapper.selectUserQD(fenye);
		Integer total = userMapper.selectCountQD(fenye);
		fenye.setRows(rows);
		fenye.setTotal(total);
		return fenye;
	}
	@Override
	public Integer updaetQD(Integer u_id) {
		// TODO Auto-generated method stub
		Integer jg=0;
		User qd = userMapper.selectStatusQD(u_id);
		if(qd==null) {
			if(userMapper.qdcaozuo(u_id)>0) {
				return jg=3;
			}else {
				return jg=2;
			}
		}else {
		return jg=1;	
		}
	}
	@Override
	public Integer updateAllemp() {
		// TODO Auto-generated method stub
		
		Integer qiantui = userMapper.qiantui();
		return qiantui;
	}
	@Override
	public List<User> selectZixs() {
		// TODO Auto-generated method stub
		return userMapper.selectZxs();
	}
	

}
