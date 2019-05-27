package com.xz.dao;

import java.util.List;

import com.xz.entity.Fenye;
import com.xz.entity.IsFenpei;
import com.xz.entity.Role;
import com.xz.entity.User;
import com.xz.entity.UserRole;

public interface UserMapper {
	/**
	 * 多条件分页查询用户信息
	 * @param fenye
	 * @return
	 */
List<User> selectUser(Fenye<User> fenye);
    /**
     * 多条件查询总条数
     * @param fenye
     * @return
     */
Integer selectUserCount(Fenye<User> fenye);
     /**
      * 查询登录名是否重复
      * @param u_loginName
      * @return
      */
Integer selectCountByLname(String u_loginName);

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
      * 修改用户
      * @param user
      * @return
      */
Integer updateUser(User user);
    /**
     * 充值用户密码为ysd123
     * @param u_password
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
 * 查询角色
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
Integer addRoles(UserRole userRole);
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
Integer updateMima(User user);
/**
 * 用工签到页面的数据查询
 * @param fenye
 * @return
 */
List<User> selectUserQD(Fenye<User> fenye);

Integer selectCountQD(Fenye<User> fenye);
/**
 * 查询用户是否已经为已签到
 * @param u_id
 * @return
 */
User selectStatusQD(Integer u_id);
/**
 * 帮助员工签退
 * @param u_id
 * @return
 */
Integer qdcaozuo(Integer u_id);
/**
 * 员工签到
 * @param user
 * @return
 */
Integer empqd(User user);

/**
 * 一键签退
 * @param list
 * @return
 */
Integer qiantui();
/**
 * 查询出所有角色为咨询师的用户信息
 * @return
 */
List<User> selectZxs();

/**
 * 查询出所有角色为咨询师并且签到的用户信息
 * @return
 */
List<User> selectZxsFenpei();
/**
 * 查询员工的权重相关信息
 * @param fenye
 * @return
 */
List<User> selectUweight(Fenye<User> fenye);
/**
 * 查询员工权重信息的总条数
 * @param fenye
 * @return
 */
Integer selectUweightCount(Fenye<User> fenye);
/**
 * 调整员工分量顺序
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
 * 查询用户是否为已签到
 * @param u_id
 * @return
 */
Integer selectCOuntQd(Integer u_id);

Integer selectuserqd(Integer u_id);

Integer updateUsergerenqd(User user);
}
