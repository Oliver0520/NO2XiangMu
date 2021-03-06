package com.xz.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xz.entity.Fenye;
import com.xz.entity.IsFenpei;
import com.xz.entity.Role;
import com.xz.entity.User;
import com.xz.entity.UserRole;

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
/**
 * 给用户添加角色
 * @param userRole
 * @return
 */
Integer insertRole(UserRole userRole);
/**
 * 删除用户角色
 * @param userRole
 * @return
 */
Integer deleteRole(UserRole userRole);
/**
 * 登陆时更新最后登录时间
 * @param user
 * @return
 */
Integer updateLastTime(User user);
/**
 * 用户修改密码
 * @param user
 * @return
 */
Integer updateMima(User user,HttpServletRequest request);
/**
 * 用户签到界面信息查询
 * @param fenye
 * @return
 */
Fenye<User> selectUserQD(Fenye<User> fenye);
/**
 *  单独员工签退
 * @param u_id
 * @return
 */
Integer updaetQD(Integer u_id);
/**
 * 所有员工一键签退
 * @return
 */
Integer updateAllemp();
/**
 * 查询角色为咨询师角色的用户名
 * @return
 */
List<User> selectZixs();
/**
 * 分页显示用户角色为咨询师的信息
 * @param fenye
 * @return
 */
Fenye<User> selectWeight(Fenye<User> fenye);
/**
 * 调整员工分量
 * @param user
 * @return
 */
Integer updateUweight(User user);

/**
 * 打开或关闭自动分配
 * @param isfenpei
 * @return
 */
Integer updateIsFenpei(IsFenpei isfenpei);
/**
 * 查询数据库中分配是否开启
 * @return
 */
Integer selectIsORNot();




}
