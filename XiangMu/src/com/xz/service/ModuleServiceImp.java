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
		
		List<ModuleTree> mokuaiTreelist=new ArrayList<ModuleTree>();
		List<Module> mokuailist = moduleMapper.selectModule();
		for (int i = 0; i < mokuailist.size(); i++) {
			if (mokuailist.get(i).getM_parentId() == 0) {
				addtree(mokuaiTreelist, mokuailist, i);
			}
		}
		return mokuaiTreelist;
	}
	private void addtree(List<ModuleTree> mokuaiTreelist, List<Module> mokuailist, int i) {
		ModuleTree mk = new ModuleTree();
		mk.setId(mokuailist.get(i).getM_id());
		mk.setText(mokuailist.get(i).getM_name());
		ModuleTree fortree = fortree(mokuailist, i,mk);
		if(fortree!=null) {
			mokuaiTreelist.add(fortree);
		}
	}

	private ModuleTree fortree(List<Module> mokuailist, int i,ModuleTree mk) {
		List<ModuleTree> treelist = new ArrayList<ModuleTree>();
		for (int j = 0; j < mokuailist.size(); j++) {
			if (mokuailist.get(j).getM_parentId() == mokuailist.get(i).getM_id()) {
				addtree(treelist, mokuailist, j);
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
	public String selectByid(Integer m_id) {
		// TODO Auto-generated method stub
		List<Module> a = moduleMapper.selectByid(m_id);
		/*"{'message':'{\'m_id\':"+a.get(0).getM_id()+",\'m_name\':\'"+a.get(0).getM_name()+"\',\'m_parentId\':"+a.get(0).getM_parentId()+",\'m_path\':"+a.get(0).getM_path()+"',\'m_weight\':"+a.get(0).getM_weight()+"}','remark':'','success':true}";
				*/
		
		String message=  "'{\'m_id\':"+a.get(0).getM_id()+",\'m_name\':\'"+a.get(0).getM_name()+
		  "\',\'m_parentId\':"+a.get(0).getM_parentId()+",\'m_path\':\'"+a.get(0).
		  getM_path()+"',\'m_weight\':"+a.get(0).getM_weight()+"}'";
		 
		return message;
	}
	@Override
	public Integer deleteMod(Integer m_id) {
		// TODO Auto-generated method stub
		return moduleMapper.deleteMod(m_id);
	}
}
