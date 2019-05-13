package com.xz.dao;

import java.util.List;

import com.xz.entity.Module;
import com.xz.entity.Role;
import com.xz.entity.User;

public interface LoginMapper {
	/**
	 * 查询登录名是否存在
	 * @param u_loginName
	 * @return
	 */
Integer selectIs(String u_loginName);
/**
 * 根据登录名和密码查询用户信息
 * @param user
 * @return
 */
User selectUs(User user);
/**
 * 根据登录用户的uid查询角色
 * @param u_id
 * @return
 */
List<Role> selectByuId(Integer u_id); 
/**
 * 查询该角色ID下的所有模块
 * @param r_id
 * @return
 */
List<Module> selectMokuai(Integer r_id);
}
