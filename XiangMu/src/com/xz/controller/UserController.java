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
    		  map.put("msg", "�ֻ��Ų��ǵ�ǰ�˺Ű󶨵��ֻ��ţ����������!!!");
  			  map.put("success", false);
    	  }
    	  if(i==1) {
    		  map.put("msg", "ԭ���벻��ȷ,����������!!!");
  			  map.put("success", false);
    	  }
    	  if(i==2) {
    		  map.put("msg", "��������ȷ�����벻ƥ��,����������!!!");
  			  map.put("success", false);
    	  }
    	  if(i==3) {
    		  map.put("msg", "�޸�����ʧ��,�����³���!!!");
  			  map.put("success", false);
    	  }
    	  if(i==4) {
    		  map.put("msg", "�޸ĳɹ��������Ʊ�����������");
  			  map.put("success", true);
    	  }
    	  if(i==5) {
    		  map.put("msg", "��֤�벻��ȷ�������»�ȡ��֤��");
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
    		  map.put("msg", "���û���ǩ�ˣ������ظ�����!!!");
  			  map.put("success", false);
    	  }
    	  if(i==2) {
    		  map.put("msg", "ǩ��ʧ��!!!");
  			  map.put("success", false);
    	  }
    	  if(i==3) {
    		  map.put("msg", "ǩ�˳ɹ�!!!");
  			  map.put("success", true);
    	  }
    	  if(i==4) {
    		  map.put("msg", "���û�δǩ�������ܽ���ǩ�˲���!!!");
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
    		  map.put("msg", "�����Զ�����ʧ��!!!");
  			  map.put("success", false);
    	  }
    	  if(i==1) {
    		  map.put("msg", "�����Զ�����ɹ�!!!");
  			  map.put("success", false);
    	  }
    	  if(i==2) {
    		  map.put("msg", "�Զ������ѿ���!!!");
  			  map.put("success", true);
    	  }
    	  if(i==3) {
    		  map.put("msg", "�Զ������ѹر�!!!");
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
