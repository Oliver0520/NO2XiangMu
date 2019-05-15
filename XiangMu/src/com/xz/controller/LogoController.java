package com.xz.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.entity.Fenye;
import com.xz.entity.Logo;
import com.xz.entity.User;
import com.xz.service.LogoService;

@Controller
public class LogoController {
@Autowired
private LogoService logoService;
@Autowired
private Fenye<Logo> fenye;
@RequestMapping(value="/chakanrizhia",method=RequestMethod.POST)
@ResponseBody
public Fenye<Logo> getLogo(Integer page,Integer rows,Logo logo){
	fenye.setPage((page-1)*rows);
	fenye.setPageSize(rows);
	fenye.setT(logo);
	fenye=logoService.gettLogo(fenye);
	return fenye;
}
@RequestMapping(value="/showrzname",method=RequestMethod.POST)
@ResponseBody
public String selectzrname(Integer s_id) {
	String i=logoService.selectzrname(s_id);
	return i;
}

@RequestMapping(value="/insertRizhi",method=RequestMethod.POST)
@ResponseBody
public Integer insertLogo(Logo logo,HttpServletRequest Request) {
	User user = (User) Request.getSession().getAttribute("usera");
	logo.setU_id(user.getU_id());
	Integer i=logoService.insertLogo(logo);
	return i;
	
	
}

@RequestMapping(value="/logo",method=RequestMethod.POST)
@ResponseBody
public Fenye<Logo> getLogo1(Integer page,Integer rows){
	fenye.setPage((page-1)*rows);
	fenye.setPageSize(rows);
 fenye=logoService.getLogo1(fenye);
	return fenye;
	
	
}

}
