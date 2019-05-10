package com.xz.service;

import java.util.List;

import com.xz.entity.Fenye;
import com.xz.entity.Module;
import com.xz.entity.ModuleTree;
import com.xz.entity.Rm;
import com.xz.entity.Role;
import com.xz.entity.RoleModule;

public interface RoleService {
	/**
	 * 查询角色信息
	 * @param fenye
	 * @return
	 */
Fenye<Role> selectAll(Fenye<Role> fenye);
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
 * 编辑角色信息
 * @param role
 * @return
 */
Integer updateRoles(Role role);

List<ModuleTree> selectMoInR(Rm rm);
}
