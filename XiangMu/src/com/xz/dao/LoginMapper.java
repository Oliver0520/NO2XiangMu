package com.xz.dao;

import java.util.List;

import com.xz.entity.User;
import com.xz.entity.UserRole;

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
List<UserRole> selectByuId(Integer u_id); 
}
