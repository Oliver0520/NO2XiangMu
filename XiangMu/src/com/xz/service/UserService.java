package com.xz.service;

import java.util.List;

import com.xz.entity.Fenye;
import com.xz.entity.Role;
import com.xz.entity.User;

public interface UserService {
	/**
	 * 多条件分页查询用户信息
	 * @param fenye
	 * @return
	 */
Fenye<User> selectUser(Fenye<User> fenye);
    /**
     * 查询登录名是否重复
     * @param u_loginName
     * @return
     */
Integer selectCountBylname(String u_loginName);
     /**
      * 创建用户
      * @param user
      * @return
      */
Integer insertUser(User user);
      /**
       * 删除用户
       * @param u_id
       * @return
       */
Integer deleteUser(Integer u_id);
/**
 * 编辑用户
 * @param user
 * @return
 */
Integer updateUser(User user);
/**
 * 重置用户密码为ysd123
 * @param u_id
 * @return
 */
Integer chongzhimima(Integer u_id);
/**
 * 锁定用户
 * @param u_id
 * @return
 */
Integer suoding(Integer u_id);
/**
 * 解锁用户
 * @param u_id
 * @return
 */
Integer jiesuo(Integer u_id);
/**
 * 查询角色信息
 * @return
 */
List<Role> selectRole();
/**
 * 查询用户所拥有的角色
 * @param u_id
 * @return
 */
List<Role> selectMyRole(Integer u_id);
}
