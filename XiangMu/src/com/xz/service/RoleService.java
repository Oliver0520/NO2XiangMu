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
	 * ��ѯ��ɫ��Ϣ
	 * @param fenye
	 * @return
	 */
Fenye<Role> selectAll(Fenye<Role> fenye);
/**
 * ��ѯ��ɫ���Ƿ��ظ�
 * @param r_name
 * @return
 */
Integer selectRolesl(String r_name);
/**
 * ��ӽ�ɫ��Ϣ
 * @param r_name
 * @return
 */
Integer insertRole(String r_name);
/**
 * ɾ����ɫ��Ϣ
 * @param r_id
 * @return
 */
Integer deleteRoles(Integer r_id);
/**
 * �༭��ɫ��Ϣ
 * @param role
 * @return
 */
Integer updateRoles(Role role);

List<ModuleTree> selectMoInR(Rm rm);
}
