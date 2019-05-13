package com.xz.dao;

import java.util.List;

import com.xz.entity.Module;
import com.xz.entity.Role;
import com.xz.entity.User;

public interface LoginMapper {
	/**
	 * ��ѯ��¼���Ƿ����
	 * @param u_loginName
	 * @return
	 */
Integer selectIs(String u_loginName);
/**
 * ���ݵ�¼���������ѯ�û���Ϣ
 * @param user
 * @return
 */
User selectUs(User user);
/**
 * ���ݵ�¼�û���uid��ѯ��ɫ
 * @param u_id
 * @return
 */
List<Role> selectByuId(Integer u_id); 
/**
 * ��ѯ�ý�ɫID�µ�����ģ��
 * @param r_id
 * @return
 */
List<Module> selectMokuai(Integer r_id);
}
