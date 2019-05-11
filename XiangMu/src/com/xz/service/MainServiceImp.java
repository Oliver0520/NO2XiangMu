package com.xz.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.xz.entity.Module;
import com.xz.entity.Role;
import com.xz.entity.User;
@Service
public class MainServiceImp implements MainService {
     
	private Module module3;
	@Override
	public String hometree(String treeUlId,HttpServletRequest requer) {
		// TODO Auto-generated method stub
		User user = (User)requer.getSession().getAttribute("usera");
		List<Role> juese = user.getRole();
		String jg="<ul id=\"treeUlId\" class=\"easyui-tree\"><li>";
		for(int i=0;i<juese.size();i++) {
			List<Module> mokuai = juese.get(i).getModule();
			for(int j=0;j<mokuai.size();j++) {
				Module module2 = mokuai.get(j);
				if(module2.getM_parentId()==0) {
					jg=jg+"<span><a title=\""+module2.getM_id()+"\" onclick=\"navTab('"+module2.getM_name()+"','')\">"+module2.getM_name()+"</a></span>";
					jg = tree(jg, mokuai, module2);
				}
			}
		}
		jg=jg+"</li></ul>";
		return jg;
	}
	private String tree(String jg, List<Module> mokuai, Module module2) {
		jg=jg+"<ul>";
		for(int j2=0;j2<mokuai.size();j2++) {
			module3 = mokuai.get(j2);
			if(module3.getM_parentId()==module2.getM_id()) {
				jg=jg+"<li>";
				jg=jg+"<span><a title=\""+module3.getM_id()+"\" onclick=\"navTab('"+module3.getM_name()+"','"+module3.getM_path()+"')\">"+module3.getM_name()+"</a></span>";
				jg = tree(jg, mokuai, module3);
				jg=jg+"</li>";
			}
		}
		jg=jg+"</ul>";
		return jg;
	}
}
