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
List<Module> selectByid(Integer m_id);
/**
 * ɾ��ģ����Ϣ
 * @param m_id
 * @return
 */
Integer deleteMod(Integer m_id);
}
