package com.xz.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.entity.Fenye;
import com.xz.entity.Role;
import com.xz.service.RoleService;

@Controller
public class RoleController {
	@Resource
    private RoleService roleServiceImp;
	@Resource
	private Fenye<Role> fenye;
	
	
	@RequestMapping(value="/selectAll",method=RequestMethod.POST)
	@ResponseBody
	public Fenye<Role> selectAll(Integer page,Integer  rows){
		fenye.setPage((page-1)*rows);
		fenye.setPageSize(rows);
		fenye=roleServiceImp.selectAll(fenye);
		return fenye;
	}
}
