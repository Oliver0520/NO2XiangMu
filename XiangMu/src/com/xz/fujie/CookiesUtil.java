package com.xz.fujie;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/*
	 * ������Դ��������������ȡ��cookies�����ж�cookis����ز���
	 * 
	 */
@Component
public class CookiesUtil {

	/**
	 * �������ֻ�ȡcookie
	 * 
	 * @param request
	 * @param name    cookie����
	 * @return
	 */
	public  Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}

	/**
	 * ��cookie��װ��Map����
	 * 
	 * @param request
	 * @return
	 */
	private  Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

	/**
	 * ����Cookies
	 * 
	 * @param response servlet����
	 * @param value    ����ֵ
	 * @author jxf
	 */
	public HttpServletResponse setCookie(HttpServletResponse response, String name, String value, int time) {
		// newһ��Cookie����,��ֵ��Ϊ����
		String encode =null;
		// tomcat�¶�Ӧ�ù���
		
		// ���cookie��ֵ�к�������ʱ����Ҫ��cookie���б��룬��Ȼ���������
		try {
			encode = URLEncoder.encode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Cookie cookie = new Cookie(name, encode);
		cookie.setPath("/");
		cookie.setMaxAge(time);
		// ��Cookie��ӵ�Response��,ʹ֮��Ч
		response.addCookie(cookie); // addCookie������Ѿ�������ͬ���ֵ�cookie�������µĸ��Ǿɵ�cookie
		return response;
	}

}
