package com.xz.dao;

import java.util.List;

import com.xz.entity.Module;

public interface ModuleMapper {
	/**
	 * ��ѯģ����Ϣ
	 * @return
	 */
List<Module> selectModule();
/**
 * ����ģ����Ϣ
 * @param module
 * @return
 */
Integer insertMod(Module module);
/**
 * ��ѯģ�����Ʋ����ظ�
 * @param module
 * @return
 */
Integer selectMbn(Module module);
/**
 * �޸�ģ����Ϣ
 * @param module
 * @return
 */
Integer updateModu(Module module);
/**
 * ����id��ѯģ����Ϣ
 * @param m_id
 * @return
 */
Module selectByid(Integer m_id);
/**
 * ɾ��ģ����Ϣ
 * @param m_id
 * @return
 */
Integer deleteMod(Integer m_id);
/**
 * ��ѯ��ǰ�û�����ģ��ID
 * @param list
 * @return
 */
List<Module> selectByUserid(List<Integer> list);
/**
 * ��ѯ��ǰģ���Ƿ�Ӧ��
 * @param m_id
 * @return
 */
Integer selectMidIsNo(Integer m_id);
/**
 * ��ѯͬһ���ڵ����Ƿ����ظ�ģ����
 * @param module
 * @return
 */
Integer selectModuleName(Module module);
/**
 * ��ѯ��ǰģ�����Ƿ�ӵ����ģ��
 * @param m_id
 * @return
 */
Integer selectModuleChiledren(Integer m_id);
}
