package com.xz.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.xz.dao.ModuleMapper;
import com.xz.dao.UserMapper;
import com.xz.entity.Module;
import com.xz.entity.Role;
import com.xz.entity.User;
@Service
public class MainServiceImp implements MainService {
     
	private Module module3;
	@Resource
	private UserMapper userMapper;
	@Resource
	private ModuleMapper moduleMapper;
	@Override
	public String hometree(String treeUlId,HttpServletRequest requer) {
		// TODO Auto-generated method stub
		User user = (User)requer.getSession().getAttribute("usera");
		List<Role> juese = user.getRole();
		List<Integer> list=new ArrayList<Integer>();
		for (int i = 0; i < juese.size(); i++) {
			list.add(juese.get(i).getR_id());
		}
		String jg="<ul id=\"treeUlId\" class=\"easyui-tree\"><li>";
		List<Module> mokuai = moduleMapper.selectByUserid(list);
			for(int j=0;j<mokuai.size();j++) {
				Module module2 = mokuai.get(j);
				if(module2.getM_parentId()==0) {
					jg=jg+"<span><a title=\""+module2.getM_id()+"\" onclick=\"navTab('"+module2.getM_name()+"','')\">"+module2.getM_name()+"</a></span>";
					jg = tree(jg, mokuai, module2);
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
	@Override
	public Integer empqd(User user) throws ParseException {
		// TODO Auto-generated method stub
		String u_qdshijian = user.getU_qdshijian();
		String stime = user.getStime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date sd1=df.parse(u_qdshijian);
		Date sd2=df.parse(stime);
		boolean before = sd1.after(sd2);
		if(before) {
			user.setU_qdstatus(3);
		}else {
			user.setU_qdstatus(1);
		}
		Integer i = userMapper.empqd(user);
		return i;
	}
	@Override
	public String suijiNum(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String str = "ABCDEFGHIJKLMNOOPQRSTUVWXYZ";
		str += str.toLowerCase();
		str += "0123456789";
		StringBuilder sb = new StringBuilder(6);
		for(int i = 0;i<6;i++)
		{
			char ch = str.charAt(new Random().nextInt(str.length()));
			sb.append(ch);
		}
		String suijishu = sb.toString();
		request.getSession().setAttribute("suijiNum", suijishu);
		return suijishu;
	}
}
