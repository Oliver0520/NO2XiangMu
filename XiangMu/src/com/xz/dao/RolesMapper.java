package com.xz.dao;

import java.util.List;

import com.xz.entity.Fenye;
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
}
