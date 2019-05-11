package com.xz.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.service.MainService;

@Controller
public class MainController {
    @Resource
	private MainService mainServiceImp;
    @RequestMapping(value = "/hometree",method = RequestMethod.POST)
    @ResponseBody
    public String hometree(String treeUlId, HttpServletRequest requer) {
		String hometree = mainServiceImp.hometree(treeUlId, requer);
		return hometree;
	}
}
