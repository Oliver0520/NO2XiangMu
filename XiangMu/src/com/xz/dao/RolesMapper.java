package com.xz.dao;

import java.util.List;

import com.xz.entity.Fenye;
import com.xz.entity.Module;
import com.xz.entity.Role;

public interface RolesMapper {
	/**
	 * ��ҳ��ѯ��ɫ��Ϣ
	 * @return
	 */
List<Role> selectRoleAll(Fenye<Role> fenye);
/**
 * ��ѯ������
 * @return
 */
Integer selectCount();
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
 * �޸Ľ�ɫ��Ϣ
 * @param role
 * @return
 */
Integer updateRoles(Role role);

List<Module> selectMoInR();
}
