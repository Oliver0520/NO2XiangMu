package com.xz.dao;

import java.util.List;

import com.xz.entity.Module;

public interface ModuleMapper {
	/**
	 * 查询模块信息
	 * @return
	 */
List<Module> selectModule();
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
/**
 * 查询当前用户所有模块ID
 * @param list
 * @return
 */
List<Module> selectByUserid(List<Integer> list);
/**
 * 查询当前模块是否被应用
 * @param m_id
 * @return
 */
Integer selectMidIsNo(Integer m_id);
/**
 * 查询同一父节点下是否有重复模块名
 * @param module
 * @return
 */
Integer selectModuleName(Module module);
/**
 * 查询当前模块下是否拥有子模块
 * @param m_id
 * @return
 */
Integer selectModuleChiledren(Integer m_id);
}
