package com.xz.service;

import java.util.List;

import com.xz.entity.Module;
import com.xz.entity.ModuleTree;

public interface ModuleService {
	/**
	 * 查询模块信息
	 * @return
	 */
List<ModuleTree> selectModules();
/**
 * 新增模块信息
 * @param module
 * @return
 */
Integer insertMod(Module module);
/**
 * 查询模块名称不能重复
 * @param module
 * @return
 */
Integer selectMbn(Module module);
/**
 * 修改模块信息
 * @param module
 * @return
 */
Integer updateModu(Module module);
/**
 * 根据id查询模块信息
 * @param m_id
 * @return
 */
Module selectByid(Integer m_id);
/**
 * 删除模块信息
 * @param m_id
 * @return
 */
Integer deleteMod(Integer m_id);
}
