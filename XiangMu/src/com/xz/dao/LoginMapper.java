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
/**
 * 查询用户输入的登录名是否存在
 * @param u_loginName
 * @return
 */
Integer selectCountLoginName(String u_loginName);
/**
 * 查询用户输入的登录名查找用户id
 * @param u_loginName
 * @return
 */
User selectUserLoginName(String u_loginName);
/**
  *  忘记密码将用户的密码重置为ysd123
 * @param u_id
 * @return
 */
 Integer forgetLoginName(Integer u_id);
 /**
  * 修改密码错误次数
  * @param u_psdWrongTime
  * @return
  */
 Integer updateUpsdWrongTime(Integer u_id);
 /**
  * 查询密码错误次数
  * @param u_psdWrongTime
  * @return
  */
 User selectUpsdWrongTime(Integer u_id);
 /**
  *  如果错误密码次数大于三次将用户锁定不能登录
  * @return
  */
 Integer updateIslockOUt(Integer u_id);
 /**
  * 如果登陆成功加密码错误次数更改为0
  * @return
  */
 Integer chongzhiUpsdWrongTime(Integer u_id);
}
