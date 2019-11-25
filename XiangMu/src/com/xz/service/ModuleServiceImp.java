package com.xz.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xz.dao.ModuleMapper;
import com.xz.entity.Module;
import com.xz.entity.ModuleTree;

@Service
public class ModuleServiceImp implements ModuleService {
	@Resource
	private ModuleMapper moduleMapper;

	@Override
	public List<ModuleTree> selectModules() {

		List<ModuleTree> moduleTreelist = new ArrayList<ModuleTree>();
		List<Module> modulelist = moduleMapper.selectModule();
		for (int i = 0; i < modulelist.size(); i++) {
			if (modulelist.get(i).getM_parentId() == 0) {
				addtree(moduleTreelist, modulelist, i);
			}
		}
		return moduleTreelist;
	}

	private void addtree(List<ModuleTree> moduleTreelist, List<Module> modulelist, int i) {
		ModuleTree mk = new ModuleTree();
		mk.setId(modulelist.get(i).getM_id());
		mk.setText(modulelist.get(i).getM_name());
		ModuleTree fortree = fortree(modulelist, i, mk);
		if (fortree != null) {
			moduleTreelist.add(fortree);
		}
	}

	private ModuleTree fortree(List<Module> modulelist, int i, ModuleTree mk) {
		List<ModuleTree> treelist = new ArrayList<ModuleTree>();
		for (int j = 0; j < modulelist.size(); j++) {
			if (modulelist.get(j).getM_parentId() == modulelist.get(i).getM_id()) {
				addtree(treelist, modulelist, j);
			}
		}
		mk.setChildren(treelist);
		return mk;
	}

	@Override
	public Integer insertMod(Module module) {
		// TODO Auto-generated method stub
		return moduleMapper.insertMod(module);
	}

	@Override
	public Integer selectMbn(Module module) {
		// TODO Auto-generated method stub
		return moduleMapper.selectMbn(module);
	}

	@Override
	public Integer updateModu(Module module) {
		// TODO Auto-generated method stub
		Integer jg = 0;
		Integer a = moduleMapper.selectModuleName(module);
		if (a == 0) {
			Integer i = moduleMapper.updateModu(module);
			if (i > 0) {
				jg = 1;
			} else {
				jg = 2;
			}
		} else {
			jg = 3;
		}
		return jg;
	}

	@Override
	public Module selectByid(Integer m_id) {
		// TODO Auto-generated method stub
		Module a = moduleMapper.selectByid(m_id);
		return a;
	}

	@Override
	public Integer deleteMod(Integer m_id) {
		// TODO Auto-generated method stub
		// 不仅要查询当前模块是否被应用，还要查询出他是否拥有子模块
		Integer jg = 0;
		Integer selectModuleChiledren = moduleMapper.selectModuleChiledren(m_id);
		Integer in = moduleMapper.selectMidIsNo(m_id);
		if (!(in > 0)) {
			if (selectModuleChiledren == 0) {
				Integer dm = moduleMapper.deleteMod(m_id);
				if (dm > 0) {
					jg = 1;
				} else {
					jg = 2;
				}
			} else {
				jg = 4;
			}

		} else {
			jg = 3;
		}
		return jg;
	}
}
