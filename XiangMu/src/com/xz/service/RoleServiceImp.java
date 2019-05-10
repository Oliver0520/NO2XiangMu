package com.xz.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xz.dao.RolesMapper;
import com.xz.entity.Fenye;
import com.xz.entity.Module;
import com.xz.entity.ModuleTree;
import com.xz.entity.Role;
@Service
public class RoleServiceImp implements RoleService {
	@Resource
    private RolesMapper roleMapper;
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
	public List<ModuleTree> selectMoInR() {
		List<ModuleTree> mokuaiTreelist=new ArrayList<ModuleTree>();
		List<Module> mokuailist = roleMapper.selectMoInR();
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

}
