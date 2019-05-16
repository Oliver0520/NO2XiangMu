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
/**
 * ��ѯ�û�����ĵ�¼���Ƿ����
 * @param u_loginName
 * @return
 */
Integer selectCountLoginName(String u_loginName);
/**
 * ��ѯ�û�����ĵ�¼�������û�id
 * @param u_loginName
 * @return
 */
User selectUserLoginName(String u_loginName);
/**
  *  �������뽫�û�����������Ϊysd123
 * @param u_id
 * @return
 */
 Integer forgetLoginName(Integer u_id);
 /**
  * �޸�����������
  * @param u_psdWrongTime
  * @return
  */
 Integer updateUpsdWrongTime(Integer u_id);
 /**
  * ��ѯ����������
  * @param u_psdWrongTime
  * @return
  */
 User selectUpsdWrongTime(Integer u_id);
 /**
  *  ���������������������ν��û��������ܵ�¼
  * @return
  */
 Integer updateIslockOUt(Integer u_id);
 /**
  * �����½�ɹ�����������������Ϊ0
  * @return
  */
 Integer chongzhiUpsdWrongTime(Integer u_id);
}
