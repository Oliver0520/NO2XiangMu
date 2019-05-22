package com.xz.dao;

import java.util.List;

import com.xz.entity.Dynamic;
import com.xz.entity.Fenye;

public interface DynamicMapper {
	/**
	 * ����һ����̬��־
	 * @param dynamic
	 * @return
	 */
Integer SendDynamic(Dynamic dynamic);
/**
 * ��ѯ��ǰѧ����u_id
 * @param s_id
 * @return
 */
Integer selectStuUid(Integer s_id);
/**
 * ��ѯδ����Ϣ������
 * @param u_id
 * @return
 */
Integer copyDynamicCount(Fenye<Dynamic> fenye);
/**
 * ��ѯ��ǰ�û��Ķ�̬��Ϣ����
 * @param u_id
 * @return
 */
List<Dynamic> copyDynamic(Fenye<Dynamic> fenye);
/**
 * ��ѯÿ��ѧ���������û�����
 * @param u_nameCopy
 * @return
 */
String selectDyUname(Integer u_nameCopy);
/**
 * ��ѯ��ǰ�û��Ƿ�ӵ�ж�̬��Ϣ
 * @param u_nameCopy
 * @return
 */
Integer selectDyCount(Integer u_nameCopy);
/**
 * ���Ϊ�Ѷ�
 * @param d_id
 * @return
 */
Integer updateDyBit(Integer d_id);
}
