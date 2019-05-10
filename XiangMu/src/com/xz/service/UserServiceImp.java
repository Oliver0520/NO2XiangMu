package com.xz.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xz.dao.UserMapper;
import com.xz.entity.Fenye;
import com.xz.entity.Role;
import com.xz.entity.User;
import com.xz.entity.UserRole;
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

}
