package com.xz.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.service.MainService;

@Controller
public class MainController {
    @Resource
	private MainService mainServiceImp;
    @RequestMapping(value = "/hometree",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
   @ResponseBody
    public String hometree(String treeUlId, HttpServletRequest requer) {
		String hometree = mainServiceImp.hometree(treeUlId, requer);
		System.out.println(hometree);
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
}
