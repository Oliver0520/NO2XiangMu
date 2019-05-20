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
		Integer jg=0;
		Integer i =roleMapper.insertRole(r_name);
		Integer j=roleMapper.selectRname(r_name);
		if(!(j>0)) {
			if(i>0) {
				jg=3;
			}else {
				jg=2;
			}
		}else {
			jg=1;
		}
		return jg;
	}
	@Override
	public Integer deleteRoles(Integer r_id) {
		// TODO Auto-generated method stub
		Integer jg=0;
		Integer i = roleMapper.deleteRoles(r_id);
		Integer j=roleMapper.selectIShere(r_id);
		if(!(j>0)) {
			if(i>0) {
				jg=3;
			}else {
				jg=2;
			}
		}else {
			jg=1;
		}
		return jg;
	}
	@Override
	public Integer updateRoles(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.updateRoles(role);
	}
	@Override
	public List<ModuleTree> selectMoInR(Integer r_id) {
		
		List<ModuleTree> mokuaiTreelist=new ArrayList<ModuleTree>();
		
		List<Module> mokuailist = roleMapper.selectMoInR();
		
		
		for (int i = 0; i < mokuailist.size(); i++) {
			
				if (mokuailist.get(i).getM_parentId() == 0) {	
				  addtree(mokuaiTreelist, mokuailist, i,r_id);				
			         }			
		}
	
		
		return mokuaiTreelist;
	}
	private void addtree(List<ModuleTree> mokuaiTreelist, List<Module> mokuailist, int i,Integer r_id) {
		ModuleTree mk = new ModuleTree();
		mk.setId(mokuailist.get(i).getM_id());
		mk.setText(mokuailist.get(i).getM_name());

		roleModul.setR_id(r_id);
		roleModul.setM_id(mokuailist.get(i).getM_id());
		Integer selectMokuai_js_id = roleMapper.selectMoByRid(roleModul);
		if (mokuailist.get(i).getM_parentId() == 0) {
			Integer selectMokuai_isyouzi = roleMapper.selectMisnu(mokuailist.get(i).getM_id());
			if (selectMokuai_isyouzi > 0) {
				mk.setChecked(false);
			} else {
				mk.setChecked(selectMokuai_js_id == 1);
			}
		} else {
			mk.setChecked(selectMokuai_js_id == 1);
		}
		ModuleTree fortree = fortree(mokuailist, i, mk, r_id);
		if (fortree != null) {
			mokuaiTreelist.add(fortree);
		}
	}

	private ModuleTree fortree(List<Module> mokuailist, int i,ModuleTree mk,Integer r_id) {
		List<ModuleTree> treelist = new ArrayList<ModuleTree>();
		for (int j = 0; j < mokuailist.size(); j++) {
			if (mokuailist.get(j).getM_parentId() == mokuailist.get(i).getM_id()) {
				addtree(treelist, mokuailist, j,r_id);
			}
		}
		mk.setChildren(treelist);
		return mk;
	}
	public Integer InsertRolem(String m_id,Integer r_id) {
		// TODO Auto-generated method stub
		if(m_id!=null && m_id!="") {
			String[] split = m_id.split(",");
			System.out.println(split.length);
			List<RoleModule> list = new ArrayList<RoleModule>();
			for (int i = 0; i < split.length; i++) {
				RoleModule jm = new RoleModule();
				jm.setM_id(Integer.parseInt(split[i]));
				jm.setR_id(r_id);
				list.add(jm);
			}

			Integer a = roleMapper.deleteRoleModule(r_id);
			if (a >= 0) {
				roleMapper.insertRoleModule(list);
			}
		}else {
			roleMapper.deleteRoleModule(r_id);
		}
		
	return 1;
	}
	}



