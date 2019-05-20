package com.xz.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xz.entity.Fenye;
import com.xz.entity.IsFenpei;
import com.xz.entity.Role;
import com.xz.entity.User;
import com.xz.entity.UserRole;

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
/**
 * ���û���ӽ�ɫ
 * @param userRole
 * @return
 */
Integer insertRole(UserRole userRole);
/**
 * ɾ���û���ɫ
 * @param userRole
 * @return
 */
Integer deleteRole(UserRole userRole);
/**
 * ��½ʱ��������¼ʱ��
 * @param user
 * @return
 */
Integer updateLastTime(User user);
/**
 * �û��޸�����
 * @param user
 * @return
 */
Integer updateMima(User user,HttpServletRequest request);
/**
 * �û�ǩ��������Ϣ��ѯ
 * @param fenye
 * @return
 */
Fenye<User> selectUserQD(Fenye<User> fenye);
/**
 *  ����Ա��ǩ��
 * @param u_id
 * @return
 */
Integer updaetQD(Integer u_id);
/**
 * ����Ա��һ��ǩ��
 * @return
 */
Integer updateAllemp();
/**
 * ��ѯ��ɫΪ��ѯʦ��ɫ���û���
 * @return
 */
List<User> selectZixs();
/**
 * ��ҳ��ʾ�û���ɫΪ��ѯʦ����Ϣ
 * @param fenye
 * @return
 */
Fenye<User> selectWeight(Fenye<User> fenye);
/**
 * ����Ա������
 * @param user
 * @return
 */
Integer updateUweight(User user);

/**
 * �򿪻�ر��Զ�����
 * @param isfenpei
 * @return
 */
Integer updateIsFenpei(IsFenpei isfenpei);
/**
 * ��ѯ���ݿ��з����Ƿ���
 * @return
 */
Integer selectIsORNot();
}
