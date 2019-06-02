package com.xz.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.entity.Dynamic;
import com.xz.entity.Fenye;
import com.xz.entity.User;
import com.xz.service.DynamicService;

@Controller
public class DynamicController {

	@Resource
	private DynamicService dynamicServiceImp;
	
	@RequestMapping(value="/SendDynamic",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> SendDynamic(Dynamic dynamic,HttpServletRequest request) {
	   SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    String time = df.format(new Date()).toString();
	    dynamic.setD_sendTime(time);
	    Integer i = dynamicServiceImp.SendDynamic(dynamic, request);
	    Map<String, Object> map = new HashMap<String, Object>();
        if (i == 1) {
			map.put("msg", "发送失败，请重试！");
			map.put("success", false);
		}
		if (i == 2) {
			map.put("msg", "发送成功");
			map.put("success", true);
		}
    	return map;
	}
	
	@RequestMapping(value="/CopyCount",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> CopyCount(HttpServletRequest request) {
		Integer i = dynamicServiceImp.copyDynamicCount(request);
		Map<String, Object> map = new HashMap<String, Object>();
        if (i == -1) {
			map.put("msg", "暂时没有消息！");
			map.put("success", false);
			
		}
        else {
			
			request.getSession().setAttribute("weidu", i);
			map.put("success", true);
		}
    	return map;
	}
	    @RequestMapping(value="/selectCopyDynamic",method = RequestMethod.POST)
	    @ResponseBody
	public Fenye<Dynamic> selectCopyDynamic(Integer page,Integer rows, Fenye<Dynamic> fenye,Dynamic dynamic,HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("usera");	
		dynamic.setU_nameCopy(user.getU_id());
		fenye.setPage((page-1)*rows);
		fenye.setPageSize(rows);
		fenye.setT(dynamic);
		 fenye = dynamicServiceImp.CopyDynamic(fenye);
		 return fenye;
	}
	    @RequestMapping(value="/updateBit",method = RequestMethod.POST)
	    @ResponseBody
	    public Integer updateBit(Integer d_id) {
	    	return dynamicServiceImp.updateBit(d_id);
	    }
}
