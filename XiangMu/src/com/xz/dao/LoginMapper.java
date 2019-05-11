package com.xz.dao;

import java.util.List;

import com.xz.entity.User;
import com.xz.entity.UserRole;

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
List<UserRole> selectByuId(Integer u_id); 
}
