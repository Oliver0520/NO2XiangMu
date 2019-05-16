package com.xz.service;

import java.util.List;

import com.xz.entity.Module;
import com.xz.entity.ModuleTree;

public interface ModuleService {
	/**
	 * ��ѯģ����Ϣ
	 * @return
	 */
List<ModuleTree> selectModules();
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
}
