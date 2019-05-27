package com.xz.dao;

import java.util.List;

import com.xz.entity.Fenye;
import com.xz.entity.IsFenpei;
import com.xz.entity.Role;
import com.xz.entity.User;
import com.xz.entity.UserRole;

public interface UserMapper {
	/**
	 * ��������ҳ��ѯ�û���Ϣ
	 * @param fenye
	 * @return
	 */
List<User> selectUser(Fenye<User> fenye);
    /**
     * ��������ѯ������
     * @param fenye
     * @return
     */
Integer selectUserCount(Fenye<User> fenye);
     /**
      * ��ѯ��¼���Ƿ��ظ�
      * @param u_loginName
      * @return
      */
Integer selectCountByLname(String u_loginName);

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
      * �޸��û�
      * @param user
      * @return
      */
Integer updateUser(User user);
    /**
     * ��ֵ�û�����Ϊysd123
     * @param u_password
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
 * ��ѯ��ɫ
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
Integer addRoles(UserRole userRole);
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
Integer updateMima(User user);
/**
 * �ù�ǩ��ҳ������ݲ�ѯ
 * @param fenye
 * @return
 */
List<User> selectUserQD(Fenye<User> fenye);

Integer selectCountQD(Fenye<User> fenye);
/**
 * ��ѯ�û��Ƿ��Ѿ�Ϊ��ǩ��
 * @param u_id
 * @return
 */
User selectStatusQD(Integer u_id);
/**
 * ����Ա��ǩ��
 * @param u_id
 * @return
 */
Integer qdcaozuo(Integer u_id);
/**
 * Ա��ǩ��
 * @param user
 * @return
 */
Integer empqd(User user);

/**
 * һ��ǩ��
 * @param list
 * @return
 */
Integer qiantui();
/**
 * ��ѯ�����н�ɫΪ��ѯʦ���û���Ϣ
 * @return
 */
List<User> selectZxs();

/**
 * ��ѯ�����н�ɫΪ��ѯʦ����ǩ�����û���Ϣ
 * @return
 */
List<User> selectZxsFenpei();
/**
 * ��ѯԱ����Ȩ�������Ϣ
 * @param fenye
 * @return
 */
List<User> selectUweight(Fenye<User> fenye);
/**
 * ��ѯԱ��Ȩ����Ϣ��������
 * @param fenye
 * @return
 */
Integer selectUweightCount(Fenye<User> fenye);
/**
 * ����Ա������˳��
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
 * ��ѯ�û��Ƿ�Ϊ��ǩ��
 * @param u_id
 * @return
 */
Integer selectCOuntQd(Integer u_id);

Integer selectuserqd(Integer u_id);

Integer updateUsergerenqd(User user);
}
