package com.xz.dao;

import java.util.List;

import com.xz.entity.Fenye;
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
}
