package com.xz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.entity.Fenye;
import com.xz.entity.ModuleTree;
import com.xz.entity.Rm;
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
	
	@RequestMapping(value="/selectRolesl",method=RequestMethod.POST)
	@ResponseBody
	public Integer selectRolesl(String r_name) {
		return roleServiceImp.selectRolesl(r_name);
	}
	@RequestMapping(value="/insertRoles",method=RequestMethod.POST)
	@ResponseBody
	public Integer insertRoles(String r_name) {
		return roleServiceImp.insertRole(r_name);
	}
	@RequestMapping(value="/deleteRoles",method=RequestMethod.POST)
	@ResponseBody
	public Integer deleteRoles(Integer r_id) {
		return roleServiceImp.deleteRoles(r_id);
	}
	@RequestMapping(value="/updateRoles",method=RequestMethod.POST)
	@ResponseBody
	public Integer updateRoles(Role role) {
		return roleServiceImp.updateRoles(role);
	}
	@RequestMapping(value="/selectMoInR",method=RequestMethod.POST)
	@ResponseBody
	public List<ModuleTree> selectMoInR(Rm rm){
		List<ModuleTree> selectMoInR = roleServiceImp.selectMoInR(rm);
		System.out.println(selectMoInR);
		return selectMoInR;
	}
}
