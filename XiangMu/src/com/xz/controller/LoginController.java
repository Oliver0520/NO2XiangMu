package com.xz.controller;

import javax.servlet.http.Cookie;
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
import com.xz.service.LoginServiceImp;
import com.xz.fujie.CookiesUtil;

@Controller
public class LoginController {
     @Resource
	private LoginService loginService;
     @Resource
    private CookiesUtil cookiesUtil;
	@RequestMapping(value="login")
     public String relogin(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		User user=new User();
		
		Cookie u_loginName = cookiesUtil.getCookieByName(request, "u_loginName");
		Cookie u_password = cookiesUtil.getCookieByName(request, "u_password");
		if(u_loginName!=null&&u_password!=null&&u_password.getValue()!=""&&u_loginName.getValue()!="") {
			user.setU_loginName(u_loginName.getValue());
			user.setU_password(u_password.getValue());
			
			request.getSession().setAttribute("text", "123");
			
			yanzhengma(request,"123",user,"asdfas",response);		
			return "Main";		
		}else {
    	 return "Login";}
     }
     
	@RequestMapping(value="/getVerifiCode")
	@ResponseBody
	public void getVerifiCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		 * 1.������֤�� 2.����֤���ϵ��ı�����session�� 3.����֤��ͼƬ���͸��ͻ���
		 */
		SCaptcha ivc = new SCaptcha(); // �����ǵ���֤���࣬������֤������� 
		BufferedImage image = ivc.getImage();
//		System.out.println(ivc.getText());
		request.getSession().setAttribute("text", ivc.getText()); // ����֤����ı�����session��
		ivc.output(image, response.getOutputStream());// ����֤��ͼƬ��Ӧ���ͻ���

	}

	@RequestMapping(value = "/Login_authentication", method = RequestMethod.POST)
	@ResponseBody
	public String Login_authentication(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");

		String session_vcode = (String) request.getSession().getAttribute("text"); // ��session�л�ȡ��������֤��
		return session_vcode;
	}
	@RequestMapping(value="/denglu",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> yanzhengma(HttpServletRequest request, String yanzhengma, User user,String y,HttpServletResponse response)
			throws IOException, ServletException {
		
		Cookie u_loginName = cookiesUtil.getCookieByName(request, "u_loginName");
		Cookie u_password = cookiesUtil.getCookieByName(request, "u_password");
		if(u_loginName!=null&&u_password!=null&&u_password.getValue()!=""&&u_loginName.getValue()!="") {
			user.setU_loginName(u_loginName.getValue());
			user.setU_password(u_password.getValue());
		}
		Integer urid=(Integer) request.getSession().getAttribute("ur_id");
		
		String str=(String) request.getSession().getAttribute("username");
		
		Integer loginselect = loginService.loginError(user, yanzhengma, request,response,y);
		Map<String, Object> map = new HashMap<String, Object>();
		if (loginselect == 1) {
			map.put("msg", "��֤�����");
			map.put("success", false);
		}
		if (loginselect == 2) {
			map.put("msg", "�û���������");
			map.put("success", false);
		}
		if (loginselect == 3) {
			map.put("msg", "������������������������Σ��˺Ž�������������ϵ����Ա");
			map.put("success", false);
		}
		if (loginselect == 4) {
			map.put("msg", "���û�������");
			map.put("success", false);
		}
		if (loginselect == 0) {
			map.put("msg", "��½�ɹ�");
			map.put("success", true);
			map.put("usedata", str);
			map.put("urid",urid);
		}
		
		return map;
	}
	@RequestMapping(value="/forgetMima",method=RequestMethod.POST)
	@ResponseBody
    public Map<String, Object> forgetMima(User user,HttpServletRequest request) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	Integer i = loginService.forgetPassword(user, request);
    	if (i == 1) {
			map.put("msg", "��֤�����");
			map.put("success", false);
		}
    	if (i == 2) {
			map.put("msg", "�û���������");
			map.put("success", false);
		}
    	if (i == 3) {
			map.put("msg", "��������ʧ��");
			map.put("success", false);
		}
    	if (i == 4) {
			map.put("msg", "�������������ã�����Ϊ��ysd123�������Ʊ����������룡");
			map.put("success", true);
		}
    	return map;
    }
	@RequestMapping(value="/clearCookie",method=RequestMethod.POST)
	public void ClearCookie(HttpServletResponse response) {
		cookiesUtil.setCookie(response, "u_loginName", "", 0);
		cookiesUtil.setCookie(response, "u_password", "", 0);
	}
}
