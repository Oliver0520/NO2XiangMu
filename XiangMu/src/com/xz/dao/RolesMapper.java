package com.xz.dao;

import java.util.List;

import com.xz.entity.Fenye;
import com.xz.entity.Module;
import com.xz.entity.Rm;
import com.xz.entity.Role;
import com.xz.entity.RoleModule;

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
Integer selectCount(Fenye<Role> fenye);
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

Integer selectMoByRid(RoleModule roleModul);

Integer selectMisnu(Integer m_parentId);

Integer insertRoleModule(List<RoleModule> list_jm);

Integer deleteRoleModule(Integer r_id);
/**
 * ��ѯ��ǰ��ɫ���Ƿ�������û�
 * @param r_id
 * @return
 */
Integer selectIShere(Integer r_id);
/**
 * ��ѯ��ǰ��ɫ���Ƿ��ظ�
 * @param r_name
 * @return
 */
Integer selectRname(String r_name);
}
