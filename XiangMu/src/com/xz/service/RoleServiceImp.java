package com.xz.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xz.dao.RolesMapper;
import com.xz.entity.Fenye;
import com.xz.entity.Module;
import com.xz.entity.ModuleTree;
import com.xz.entity.Rm;
import com.xz.entity.Role;
import com.xz.entity.RoleModule;
@Service
public class RoleServiceImp implements RoleService {
	@Resource
    private RolesMapper roleMapper;
	@Resource
	private RoleModule roleModul;
	@Resource
	private Module module;
	@Override
	public Fenye<Role> selectAll(Fenye<Role> fenye) {
		// TODO Auto-generated method stub
		Integer total = roleMapper.selectCount();
		List<Role> rows = roleMapper.selectRoleAll(fenye);
		fenye.setTotal(total);
		fenye.setRows(rows);
		return fenye;
	}
	@Override
	public Integer selectRolesl(String r_name) {
		// TODO Auto-generated method stub
		return roleMapper.selectRolesl(r_name);
	}
	@Override
	public Integer insertRole(String r_name) {
		// TODO Auto-generated method stub
		return roleMapper.insertRole(r_name);
	}
	@Override
	public Integer deleteRoles(Integer r_id) {
		// TODO Auto-generated method stub
		return roleMapper.deleteRoles(r_id);
	}
	@Override
	public Integer updateRoles(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.updateRoles(role);
	}
	@Override
	public List<ModuleTree> selectMoInR(Rm rm) {
		
		List<ModuleTree> mokuaiTreelist=new ArrayList<ModuleTree>();
		
		List<Module> mokuailist = roleMapper.selectMoInR();
		
		
		for (int i = 0; i < mokuailist.size(); i++) {
			
				if (mokuailist.get(i).getM_parentId() == 0) {	
				  addtree(mokuaiTreelist, mokuailist, i,rm);				
			         }			
		}
	
		
		return mokuaiTreelist;
	}
	private void addtree(List<ModuleTree> mokuaiTreelist, List<Module> mokuailist, int i,Rm rm) {
		ModuleTree mk = new ModuleTree();
		mk.setId(mokuailist.get(i).getM_id());
		mk.setText(mokuailist.get(i).getM_name());	
		
		List<Module> mokuailist1= roleMapper.selectMoByRid(rm);
		
			for (int f = 0; f < mokuailist1.size(); f++) {
				if(mokuailist.get(i).getM_id()==mokuailist1.get(f).getM_id()) {
					mk.setChecked(true);
				}else {
					mk.setChecked(false);
				}
			
		}
		
					
		ModuleTree fortree = fortree(mokuailist, i,mk,rm);
		if(fortree!=null) {
			mokuaiTreelist.add(fortree);
		}
	}

	private ModuleTree fortree(List<Module> mokuailist, int i,ModuleTree mk,Rm rm) {
		List<ModuleTree> treelist = new ArrayList<ModuleTree>();
		for (int j = 0; j < mokuailist.size(); j++) {
			if (mokuailist.get(j).getM_parentId() == mokuailist.get(i).getM_id()) {
				addtree(treelist, mokuailist, j,rm);
			}
		}
		mk.setChildren(treelist);
		return mk;
	}

}
