package com.xz.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.entity.User;
import com.xz.service.MainService;

@Controller
public class MainController {
    @Resource
	private MainService mainServiceImp;
    @Resource
    private User user;
    @RequestMapping(value = "/hometree",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
   @ResponseBody
    public String hometree(String treeUlId, HttpServletRequest request) {
		String hometree = mainServiceImp.hometree(treeUlId, request);
		return hometree;
	}
    
    @RequestMapping(value = "tuichu")
	public String tuichu(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().setAttribute("usera", null);
		/*
		 * cookiesUtil.setCookie(response, "us_name", "", 0);
		 * cookiesUtil.setCookie(response, "us_password", "", 0);
		 */
		return "Login";
	}
    @RequestMapping(value="/empqd",method=RequestMethod.POST)
    @ResponseBody
    public Integer empqd(String time,HttpServletRequest request) throws ParseException {
    	user.setU_qdshijian(time);
        User usera = (User) request.getSession().getAttribute("usera");  
        user.setU_id( usera.getU_id());
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String a=df.format(new Date())+" 09:00:00";
        user.setStime(a);
        Integer i = mainServiceImp.empqd(user);
    	return i;
    }
}
