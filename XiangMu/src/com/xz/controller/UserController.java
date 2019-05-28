package com.xz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.entity.Fenye;
import com.xz.entity.IsFenpei;
import com.xz.entity.Role;
import com.xz.entity.User;
import com.xz.entity.UserRole;
import com.xz.fujie.MD5Util;
import com.xz.service.UserService;

@Controller
public class UserController {
      @Resource
	   private UserService userServiceImp;
      @Resource
      private Fenye<User> fenye;
      
      @RequestMapping(value="/EmployeeQd")
  	private String EmployeeQd() {

		return "EmployeeQd";
	}
      @RequestMapping(value="/UserManager")
    	private String UserManager() {

    		return "UserManager";
    	}
     
      
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
      @RequestMapping(value="/deleteRole",method=RequestMethod.POST)
      @ResponseBody
      public Integer deleteRole(UserRole userRole) {
    	  return userServiceImp.deleteRole(userRole);
      }
      @RequestMapping(value="/xiugaimima",method=RequestMethod.POST)
      @ResponseBody
      public Map<String, Object> xiugaimima(User user,HttpServletRequest request,String phone) {
    	 
    	  Map<String, Object> map = new HashMap<String, Object>();
    	  user.setU_phoneNumber(phone);
    	  Integer i = userServiceImp.updateMima(user, request);
    	  if(i==6) {
    		  map.put("msg", "手机号不是当前账号绑定的手机号，请更换尝试!!!");
  			  map.put("success", false);
    	  }
    	  if(i==1) {
    		  map.put("msg", "原密码不正确,请重新输入!!!");
  			  map.put("success", false);
    	  }
    	  if(i==2) {
    		  map.put("msg", "新密码与确认密码不匹配,请重新输入!!!");
  			  map.put("success", false);
    	  }
    	  if(i==3) {
    		  map.put("msg", "修改密码失败,请重新尝试!!!");
  			  map.put("success", false);
    	  }
    	  if(i==4) {
    		  map.put("msg", "修改成功，请妥善保管您的密码");
  			  map.put("success", true);
    	  }
    	  if(i==5) {
    		  map.put("msg", "验证码不正确，请重新获取验证码");
  			  map.put("success", false);
    	  }
    	  return map;
      }
      @RequestMapping(value="/selectUserQD",method=RequestMethod.POST)
      @ResponseBody
      public Fenye<User> selectUserQD(Integer page,Integer rows,User user){
    	  fenye.setPage((page-1)*rows);
    	  fenye.setPageSize(rows);
    	  fenye.setT(user);
    	  fenye=userServiceImp.selectUserQD(fenye);
    	  return fenye;
      }
      @RequestMapping(value="/qdCaozuo",method=RequestMethod.POST)
      @ResponseBody
      public Map<String, Object> qdCaozuo(Integer u_id){
    	  Integer i = userServiceImp.updaetQD(u_id);
    	  Map<String, Object> map = new HashMap<String, Object>();
    	  if(i==1) {
    		  map.put("msg", "该用户已签退，不能重复操作!!!");
  			  map.put("success", false);
    	  }
    	  if(i==2) {
    		  map.put("msg", "签退失败!!!");
  			  map.put("success", false);
    	  }
    	  if(i==3) {
    		  map.put("msg", "签退成功!!!");
  			  map.put("success", true);
    	  }
    	  if(i==4) {
    		  map.put("msg", "该用户未签到，不能进行签退操作!!!");
  			  map.put("success", false);
    	  }
    	  return map;
      }
      @RequestMapping(value="/qiantui",method=RequestMethod.POST)
      @ResponseBody
      public Integer qiantui() {
    	  return userServiceImp.updateAllemp();
      }
      @RequestMapping(value="MyselfInfo")
      public String MyselfInfo() {
    	  return "MyselfInfo";
      }      
      @RequestMapping(value="/myselfIn",method=RequestMethod.POST)
      @ResponseBody
      public User myselfIn(HttpServletRequest req){
    	  User list = (User) req.getSession().getAttribute("usera");
    	  return list;
      }
      @RequestMapping(value="/selectZXS",method=RequestMethod.POST)
      @ResponseBody
      public List<User> selectZXS(){
    	  return userServiceImp.selectZixs();
      }
      @RequestMapping(value="/selectUweight",method = RequestMethod.POST)
      @ResponseBody
      public Fenye<User> selectUweight(Integer page,Integer rows,User user){
    	  fenye.setPage((page-1)*rows);
    	  fenye.setPageSize(rows);
    	  fenye.setT(user);
    	  fenye=userServiceImp.selectWeight(fenye);
    	  return fenye;
      }
      @RequestMapping(value="/Empweight")
      public String Empweight() {
    	  return "EmpWeight";
      }
      @RequestMapping(value="/updateUweight",method=RequestMethod.POST)
      @ResponseBody
      public Integer updateUweight(User user) {
    	  return userServiceImp.updateUweight(user);
      }
      @RequestMapping(value="/updateIsFenpei",method=RequestMethod.POST)
      @ResponseBody
      public Map<String, Object> updateIsFenpei(IsFenpei isFenpei) {
    	  Integer i = userServiceImp.updateIsFenpei(isFenpei);
    	  Map<String, Object> map = new HashMap<String, Object>();
    	  if(i==0) {
    		  map.put("msg", "开启自动分配失败!!!");
  			  map.put("success", false);
    	  }
    	  if(i==1) {
    		  map.put("msg", "开启自动分配成功!!!");
  			  map.put("success", false);
    	  }
    	  if(i==2) {
    		  map.put("msg", "自动分配已开启!!!");
  			  map.put("success", true);
    	  }
    	  if(i==3) {
    		  map.put("msg", "自动分配已关闭!!!");
  			  map.put("success", true);
    	  }
    	  return map;
      }
      @RequestMapping(value="/selectIsORNot",method=RequestMethod.POST)
      @ResponseBody
      public Integer selectIsORNot() {
    	  return userServiceImp.selectIsORNot();
      }
}
