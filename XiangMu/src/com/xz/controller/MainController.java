package com.xz.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.xz.entity.User;
import com.xz.fujie.Aliyun;
import com.xz.fujie.CookiesUtil;
import com.xz.service.MainService;

@Controller
public class MainController {
    @Resource
	private MainService mainServiceImp;
    @Resource
    private User user;
    @Resource
    private Aliyun aliyun;
    @Resource
    private CookiesUtil cookiesUtil;
    @RequestMapping(value = "/hometree",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
   @ResponseBody
    public String hometree(String treeUlId, HttpServletRequest request) {
		String hometree = mainServiceImp.hometree(treeUlId, request);
		request.getSession().getAttribute("usera");
		Integer qdstatus = user.getU_qdstatus();
		request.getSession().setAttribute("qdstatus", qdstatus);
		return hometree;
	}
    
    @RequestMapping(value = "tuichu")
	public String tuichu(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().setAttribute("usera", null);
		cookiesUtil.setCookie(response, "u_loginName", "", 0);
		cookiesUtil.setCookie(response, "u_password", "", 0);
		return "Login";
	}
    @RequestMapping(value="/empqd",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> empqd(String time,HttpServletRequest request) throws ParseException {
    	user.setU_qdshijian(time);
        User usera = (User) request.getSession().getAttribute("usera");  
        user.setU_id( usera.getU_id());
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String a=df.format(new Date())+" 09:00:00";
        user.setStime(a);
        Integer i = mainServiceImp.empqd(user);
        Map<String, Object> map = new HashMap<String, Object>();
        if (i == 1) {
			map.put("msg", "今天已签到，请不要重复签到");
			map.put("success", false);
		}
		if (i == 2) {
			map.put("msg", "签到失败，请联系管理员");
			map.put("success", false);
		}
		if (i == 3) {
			map.put("msg", "签到成功，祝您拥有一个美好的一天！！！");
			map.put("success", true);
		}
    	return map;
    }
    @RequestMapping(value="/empqt",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object>  empqt(String time,HttpServletRequest request) throws ParseException {
    	user.setU_qdshijian(time);
        User usera = (User) request.getSession().getAttribute("usera");  
        user.setU_id( usera.getU_id());
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String a=df.format(new Date())+" 17:00:00";
        user.setStime(a);
        Integer i = mainServiceImp.empqt(user);
        Map<String, Object> map = new HashMap<String, Object>();
        if (i == 1) {
			map.put("msg", "签退成功，祝您生活愉快！");
			map.put("success", true);
		}
		if (i == 2) {
			map.put("msg", "签退失败，请联系管理员");
			map.put("success", false);
		}
		if (i == 3) {
			map.put("msg", "您今天未进行签到，不能进行签退操作");
			map.put("success", false);
		}
		if (i == 4) {
			map.put("msg", "还未到下班时间，不能进行签退操作");
			map.put("success", false);
		}
    	return map;
    }
    
    @RequestMapping(value="/sendyanzhengma",method = RequestMethod.POST)
    @ResponseBody
    public Integer sendyanzhengma(String phone,HttpServletRequest request) throws ClientException {
    	String suijiNum = mainServiceImp.suijiNum(request);
    	String templateCode="SMS_165109439";
    	String templateParam="{'code':'"+suijiNum+"'}";
    	SendSmsResponse sendSms = Aliyun.sendSms(phone,templateParam,templateCode);    	
  	System.out.println(sendSms.getCode());
    	String fhz = sendSms.getCode();
    	Integer rez=0;
    	if("OK".equals(fhz)) {
    		rez=1;
    	}
    	return rez;
    }
}
