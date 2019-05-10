package com.xz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.entity.Fenye;
import com.xz.entity.Role;
import com.xz.entity.User;
import com.xz.entity.UserRole;
import com.xz.service.UserService;

@Controller
public class UserController {
      @Resource
	   private UserService userServiceImp;
      @Resource
      private Fenye<User> fenye;
      
      @RequestMapping(value="/selectUser",method=RequestMethod.POST)
      @ResponseBody
      public Fenye<User> selectUser(Integer page,Integer rows,User user){
    	  fenye.setPage((page-1)*rows);
    	  fenye.setPageSize(rows);
    	  fenye.setT(user);
    	  fenye=userServiceImp.selectUser(fenye);
    	  return fenye;
      }
      
      @RequestMapping(value="/selectCountByLname",method=RequestMethod.POST)
      @ResponseBody
      public Integer selectCountByLname(String u_loginName) {
    	  Integer i = userServiceImp.selectCountBylname(u_loginName);
    	  return i;
      }
      
      @RequestMapping(value="/insertUser",method=RequestMethod.POST)
      @ResponseBody
      public Integer insertUser(User user) {
    	  Integer i = userServiceImp.insertUser(user);
    	  return i;
      }
      
      @RequestMapping(value="/deleteUser",method=RequestMethod.POST)
      @ResponseBody
      public Integer deleteUser(Integer u_id) {
    	  Integer i = userServiceImp.deleteUser(u_id);
    	  return i;
      }
      @RequestMapping(value="/updateUser",method=RequestMethod.POST)
      @ResponseBody
      public Integer updateUser(User user) {
    	  Integer i = userServiceImp.updateUser(user);
    	  return i;
      }
      @RequestMapping(value="/chongzhimima",method=RequestMethod.POST)
      @ResponseBody
      public Integer chongzhimima(Integer u_id) {
    	  Integer i = userServiceImp.chongzhimima(u_id);
    	  return i;
      }
      @RequestMapping(value="/suoding",method=RequestMethod.POST)
      @ResponseBody
      public Integer suoding(Integer u_id) {
    	  Integer i = userServiceImp.suoding(u_id);
    	  return i;
      }
      @RequestMapping(value="/jiesuo",method=RequestMethod.POST)
      @ResponseBody
      public Integer jiesuo(Integer u_id) {
    	  Integer i = userServiceImp.jiesuo(u_id);
    	  return i;
      }
      @RequestMapping(value="/selectRole",method=RequestMethod.POST)
      @ResponseBody
      public List<Role> selectRole(){
    	  List<Role> rows = userServiceImp.selectRole();
    	  return rows;
      }
      @RequestMapping(value="/selectMyRole",method=RequestMethod.POST)
      @ResponseBody
      public List<Role> selectMyRole(Integer u_id){
    	  List<Role> rows = userServiceImp.selectMyRole(u_id);
    	  return rows;
      }
      @RequestMapping(value="/insertRole",method=RequestMethod.POST)
      @ResponseBody
      public Integer insertRole(UserRole userRole) {
    	  return userServiceImp.insertRole(userRole);
      }
}
