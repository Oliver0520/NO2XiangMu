package com.xz.service;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.xz.dao.LoginMapper;
import com.xz.entity.Module;
import com.xz.entity.Role;
import com.xz.entity.User;
import com.xz.entity.UserRole;
import com.xz.fujie.CookiesUtil;
import com.xz.fujie.MD5Util;

@Service
public class LoginServiceImp implements LoginService {
	@Resource
	private LoginMapper loginMapper;
	@Resource
	private UserService userService;
	@Resource
	private Role role;
	@Resource
	private CookiesUtil cookiesUtil;

	@Override
	public Integer loginError(User user, String yanzhengma, HttpServletRequest request, HttpServletResponse response,
			String y) {
		// TODO Auto-generated method stub
		Integer jg = 0;
		String paduanyong =user.getU_loginName();
		String upsd = user.getU_password();
		String ulname = user.getU_loginName();
		String lname = MD5Util.string2MD5(user.getU_loginName());
		String yanz = (String) request.getSession().getAttribute("text");
		if (!("asdfas".equals(y)))  {
			paduanyong= MD5Util.string2MD5(paduanyong);
		}
		if (yanz.equalsIgnoreCase(yanzhengma)) {
			if (loginMapper.selectIs(lname) == 1||loginMapper.selectIs(ulname) == 1) {
				if (!("asdfas".equals(y)))  {
					user.setU_password(MD5Util.string2MD5(user.getU_password()));
					user.setU_loginName(lname);
				}else {
					user.setU_loginName(paduanyong);
				}
				
				user = loginMapper.selectUs(user);
				if (user != null) {
					if (user.getU_isLockout() == 0) {
						User user2 = new User();
						Date date = new Date();
						SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
						String format2 = format.format(date);
						user2.setU_lastLoginTime(format2);
						user2.setU_id(user.getU_id());
						userService.updateLastTime(user2);
						List<Role> selectJuese = loginMapper.selectByuId(user.getU_id());
						for (int i = 0; i < selectJuese.size(); i++) {
							List<Module> selectMokuai = loginMapper.selectMokuai(selectJuese.get(i).getR_id());
							selectJuese.get(i).setModule(selectMokuai);
						}
						user.setRole(selectJuese);
						request.getSession().setAttribute("usera", user);
						Integer qdstatus = user.getU_qdstatus();
						request.getSession().setAttribute("qdstatus", qdstatus);
						User deuid = loginMapper.selectUserLoginName(paduanyong);
						loginMapper.chongzhiUpsdWrongTime(deuid.getU_id());
					} else {
						jg = 4;
					}
				} else {
					
					User deuid = loginMapper.selectUserLoginName(paduanyong);
					loginMapper.updateUpsdWrongTime(deuid.getU_id());
					User uwrongTime = loginMapper.selectUpsdWrongTime(deuid.getU_id());
					if (uwrongTime.getU_psdWrongTime() > 2) {
						loginMapper.updateIslockOUt(deuid.getU_id());
					}
					jg = 3;
				}
			} else {
				jg = 2;
			}
		} else {
			jg = 1;
		}
		return jg;
	}

	@Override
	public Integer forgetPassword(User user, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Integer jg = 0;
		String u_loginName =MD5Util.string2MD5(user.getU_loginName()).toString() ;

		String suijiNum = (String) request.getSession().getAttribute("suijiNum");
		if (user.getYanzheng().equals(suijiNum)) {
			Integer scln = loginMapper.selectCountLoginName(u_loginName);
			if (scln > 0) {
				User lname = loginMapper.selectUserLoginName(u_loginName);
				Integer forgetLoginName = loginMapper.forgetLoginName(lname.getU_id());
				if (forgetLoginName > 0) {
					return 4;
				} else {
					return 3;
				}
			} else {
				return 2;
			}
		} else {
			return 1;
		}
	}

}
