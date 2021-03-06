package com.xz.dao;

import java.util.List;

import com.xz.entity.Fenye;
import com.xz.entity.Module;
import com.xz.entity.Rm;
import com.xz.entity.Role;
import com.xz.entity.RoleModule;

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
Integer selectCount(Fenye<Role> fenye);
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

Integer selectMoByRid(RoleModule roleModul);

Integer selectMisnu(Integer m_parentId);

Integer insertRoleModule(List<RoleModule> list_jm);

Integer deleteRoleModule(Integer r_id);
/**
 * 查询当前角色下是否分配了用户
 * @param r_id
 * @return
 */
Integer selectIShere(Integer r_id);
/**
 * 查询当前角色名是否重复
 * @param r_name
 * @return
 */
Integer selectRname(String r_name);
}
