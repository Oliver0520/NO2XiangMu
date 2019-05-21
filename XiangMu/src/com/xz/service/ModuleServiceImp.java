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
		
		List<ModuleTree> moduleTreelist=new ArrayList<ModuleTree>();
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
		ModuleTree fortree = fortree(modulelist, i,mk);
		if(fortree!=null) {
			moduleTreelist.add(fortree);
		}
	}

	private ModuleTree fortree(List<Module> modulelist, int i,ModuleTree mk) {
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
		return moduleMapper.updateModu(module);
	}
	@Override
	public Module selectByid(Integer m_id) {
		// TODO Auto-generated method stub
	Module a = moduleMapper.selectByid(m_id);
		/*"{'message':'{\'m_id\':"+a.get(0).getM_id()+",\'m_name\':\'"+a.get(0).getM_name()+"\',\'m_parentId\':"+a.get(0).getM_parentId()+",\'m_path\':"+a.get(0).getM_path()+"',\'m_weight\':"+a.get(0).getM_weight()+"}','remark':'','success':true}";
				*/
		
		/*
		 * String message=
		 * "'{\'m_id\':"+a.get(0).getM_id()+",\'m_name\':\'"+a.get(0).getM_name()+
		 * "\',\'m_parentId\':"+a.get(0).getM_parentId()+",\'m_path\':\'"+a.get(0).
		 * getM_path()+"',\'m_weight\':"+a.get(0).getM_weight()+"}'";
		 */
		 
		return a;
	}
	@Override
	public Integer deleteMod(Integer m_id) {
		// TODO Auto-generated method stub
		return moduleMapper.deleteMod(m_id);
	}
}
