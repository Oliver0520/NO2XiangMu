package com.xz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@RequestMapping(value="/RolesManager")
	private String RolesManager() {
		return "RolesManager";
	}
	
	
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
	public Map<String, Object> insertRoles(String r_name) {
		Integer i = roleServiceImp.insertRole(r_name);
		Map<String, Object> map = new HashMap<String, Object>();
		if (i == 1) {
			map.put("msg", "角色名已被占用，请重试");
			map.put("success", false);
		}
		if (i == 2) {
			map.put("msg", "新增失败");
			map.put("success", false);
		}
		if (i == 3) {
			map.put("msg", "新增成功");
			map.put("success", true);
		}
		return map;
	}
	@RequestMapping(value="/deleteRoles",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteRoles(Integer r_id) {
		Integer i = roleServiceImp.deleteRoles(r_id);
		Map<String, Object> map = new HashMap<String, Object>();
		if (i == 1) {
			map.put("msg", "该角色还有用户在使用，请先解绑在进行尝试");
			map.put("success", false);
		}
		if (i == 2) {
			map.put("msg", "删除失败");
			map.put("success", false);
		}
		if (i == 3) {
			map.put("msg", "删除成功");
			map.put("success", true);
		}
		return map;
	}
	@RequestMapping(value="/updateRoles",method=RequestMethod.POST)
	@ResponseBody
	public Integer updateRoles(Role role) {
		return roleServiceImp.updateRoles(role);
	}
	@RequestMapping(value="/selectMoInR",method=RequestMethod.POST)
	@ResponseBody
	public List<ModuleTree> selectMoInR(Integer r_id){
		List<ModuleTree> selectMoInR = roleServiceImp.selectMoInR(r_id);
		return selectMoInR;
	}
	@RequestMapping(value="/insertRoleModule",method=RequestMethod.POST)
	@ResponseBody
	public Integer insertRoleModule(String m_id,Integer r_id) {
		Integer i = roleServiceImp.InsertRolem(m_id, r_id);
		return i;
	}
}
