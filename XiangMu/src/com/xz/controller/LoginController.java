package com.xz.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.entity.User;
import com.xz.fujie.SCaptcha;
import com.xz.service.LoginService;

@Controller
public class LoginController {
     @Resource
	private LoginService loginService;
	
	@RequestMapping(value="/getVerifiCode")
	@ResponseBody
	public void getVerifiCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		 * 1.生成验证码 2.把验证码上的文本存在session中 3.把验证码图片发送给客户端
		 */
		SCaptcha ivc = new SCaptcha(); // 用我们的验证码类，生成验证码类对象 
		BufferedImage image = ivc.getImage();
//		System.out.println(ivc.getText());
		request.getSession().setAttribute("text", ivc.getText()); // 将验证码的文本存在session中
		ivc.output(image, response.getOutputStream());// 将验证码图片响应给客户端

	}

	@RequestMapping(value = "/Login_authentication", method = RequestMethod.POST)
	@ResponseBody
	public String Login_authentication(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");

		String session_vcode = (String) request.getSession().getAttribute("text"); // 从session中获取真正的验证码
		return session_vcode;
	}
	@RequestMapping(value="/denglu",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> yanzhengma(HttpServletRequest request, String yanzhengma, User user,String y)
			throws IOException, ServletException {
		Integer urid=(Integer) request.getSession().getAttribute("ur_id");
		
		String str=(String) request.getSession().getAttribute("username");
		//System.out.println("长度为"+selectuserjuese.size());
		
		Integer loginselect = loginService.loginError(user, yanzhengma, request);
		Map<String, Object> map = new HashMap<String, Object>();
		if (loginselect == 1) {
			map.put("msg", "验证码错误");
			map.put("success", false);
		}
		if (loginselect == 2) {
			map.put("msg", "用户名不存在");
			map.put("success", false);
		}
		if (loginselect == 3) {
			map.put("msg", "密码输入错误");
			map.put("success", false);
		}
		if (loginselect == 4) {
			map.put("msg", "该用户被锁定");
			map.put("success", false);
		}
		if (loginselect == 0) {
			map.put("msg", "登陆成功");
			map.put("success", true);
			map.put("usedata", str);
			map.put("urid",urid);
		}
		
		return map;
	}

}
