package com.xz.service;

import java.util.List;

import com.xz.entity.Fenye;
import com.xz.entity.Role;
import com.xz.entity.User;

public interface UserService {
	/**
	 * ��������ҳ��ѯ�û���Ϣ
	 * @param fenye
	 * @return
	 */
Fenye<User> selectUser(Fenye<User> fenye);
    /**
     * ��ѯ��¼���Ƿ��ظ�
     * @param u_loginName
     * @return
     */
Integer selectCountBylname(String u_loginName);
     /**
      * �����û�
      * @param user
      * @return
      */
Integer insertUser(User user);
      /**
       * ɾ���û�
       * @param u_id
       * @return
       */
Integer deleteUser(Integer u_id);
/**
 * �༭�û�
 * @param user
 * @return
 */
Integer updateUser(User user);
/**
 * �����û�����Ϊysd123
 * @param u_id
 * @return
 */
Integer chongzhimima(Integer u_id);
/**
 * �����û�
 * @param u_id
 * @return
 */
Integer suoding(Integer u_id);
/**
 * �����û�
 * @param u_id
 * @return
 */
Integer jiesuo(Integer u_id);
/**
 * ��ѯ��ɫ��Ϣ
 * @return
 */
List<Role> selectRole();
/**
 * ��ѯ�û���ӵ�еĽ�ɫ
 * @param u_id
 * @return
 */
List<Role> selectMyRole(Integer u_id);
}
