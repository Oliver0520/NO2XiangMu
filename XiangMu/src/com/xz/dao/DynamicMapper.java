package com.xz.dao;

import java.util.List;

import com.xz.entity.Dynamic;
import com.xz.entity.Fenye;

public interface DynamicMapper {
	/**
	 * 发送一条动态日志
	 * @param dynamic
	 * @return
	 */
Integer SendDynamic(Dynamic dynamic);
/**
 * 查询当前学生的u_id
 * @param s_id
 * @return
 */
Integer selectStuUid(Integer s_id);
/**
 * 查询未读消息总条数
 * @param u_id
 * @return
 */
Integer copyDynamicCount(Fenye<Dynamic> fenye);
/**
 * 查询当前用户的动态消息条数
 * @param u_id
 * @return
 */
List<Dynamic> copyDynamic(Fenye<Dynamic> fenye);
/**
 * 查询每条学生的所有用户名称
 * @param u_nameCopy
 * @return
 */
String selectDyUname(Integer u_nameCopy);
/**
 * 查询当前用户是否拥有动态消息
 * @param u_nameCopy
 * @return
 */
Integer selectDyCount(Integer u_nameCopy);
/**
 * 标记为已读
 * @param d_id
 * @return
 */
Integer updateDyBit(Integer d_id);
}
