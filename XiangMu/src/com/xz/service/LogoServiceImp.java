package com.xz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xz.dao.LogoMapper;
import com.xz.entity.Fenye;
import com.xz.entity.Logo;
import com.xz.entity.Student;

@Service
public class LogoServiceImp implements LogoService {
	@Autowired
	private Logo logo;
	@Autowired
	private LogoMapper logomapper;
	@Override
	public Fenye<Logo> gettLogo(Fenye<Logo> fenye) {
		// TODO Auto-generated method stub
		Integer countStu = logomapper.selectCount(fenye);
		List<Logo> logo = logomapper.selectLogo(fenye);
		//循环查询学生ID，通过学生ID分别去查对应的学生姓名，再把查询出的学生姓名Set进学生ID里
		for (int i = 0; i < logo.size(); i++) {
			Integer s_id = logo.get(i).getS_id();
			String name = logomapper.selectzrname(s_id);
			logo.get(i).setRzname(name);
		}
		fenye.setRows(logo);
		fenye.setTotal(countStu);
		return fenye;
	}

	@Override
	public Integer insertLogo(Logo logo) {
		// TODO Auto-generated method stub
		return logomapper.insertLogo(logo);
	}

	@Override
	public Integer selectCounut(Fenye<Logo> fenye) {
		// TODO Auto-generated method stub
		return logomapper.selectCount(fenye);
	}

	@Override
	public String selectzrname(Integer s_id) {
		// TODO Auto-generated method stub
		return logomapper.selectzrname(s_id);
	}

	
	  @Override 
	  public Fenye<Logo> getLogo1(Fenye<Logo> fenye) {
		  // TODOAuto-generated method stub 
		  Integer countLogo1 =logomapper.selectCountLogo1(fenye); 
		  List<Logo> selectLogo1 =logomapper.selectLogo1(fenye); 
		  for(int i=0; i< selectLogo1.size(); i++) {
			  
			  Integer s_id = selectLogo1.get(i).getS_id();
			  String stuname =logomapper.selectstudentname(s_id);
			  selectLogo1.get(i).setStudentname(stuname);
			  
			  Integer u_id =selectLogo1.get(i).getU_id();
			  String uname =logomapper.selectusername(u_id);
			  selectLogo1.get(i).setUsername(uname);
		  }
		  
		  
		  
		  fenye.setTotal(countLogo1); 
		  fenye.setRows(selectLogo1);
		 
	 return fenye; 
	 }
	 

	/*
	 * @Override public String selects_name(Student student) { // TODO
	 * Auto-generated method stub return logomapper.selects_name(student); }
	 */

	
}
