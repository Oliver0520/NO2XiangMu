package com.xz.dao;

import java.util.List;

import com.xz.entity.Fenye;
import com.xz.entity.Module;
import com.xz.entity.Role;

public interface RolesMapper {
	/**
	 * 分页查询角色信息
	 * @return
	 */
List<Role> selectRoleAll(Fenye<Role> fenye);
/**
 * 查询总条数
 * @return
 */
Integer selectCount();
/**
 * 查询角色名是否重复
 * @param r_name
 * @return
 */
Integer selectRolesl(String r_name);
/**
 * 添加角色信息
 * @param r_name
 * @return
 */
Integer insertRole(String r_name);
/**
 * 删除角色信息
 * @param r_id
 * @return
 */
Integer deleteRoles(Integer r_id);
/**
 * 修改角色信息
 * @param role
 * @return
 */
Integer updateRoles(Role role);

List<Module> selectMoInR();
}
