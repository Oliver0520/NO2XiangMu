package com.xz.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.xz.dao.StudentMapper;
import com.xz.dao.UserMapper;
import com.xz.entity.Fenye;
import com.xz.entity.IsFenpei;
import com.xz.entity.Role;
import com.xz.entity.User;
import com.xz.entity.UserRole;
import com.xz.fujie.MD5Util;

@Service
public class UserServiceImp implements UserService {
	@Resource
	private UserMapper userMapper;
	@Resource
	private StudentMapper studentMapper;

	/**
	 * 多条件分页查询用户信息
	 */
	@Override
	public Fenye<User> selectUser(Fenye<User> fenye) {
		// TODO Auto-generated method stub

		List<User> rows = userMapper.selectUser(fenye);
		Integer total = userMapper.selectUserCount(fenye);
		fenye.setRows(rows);
		fenye.setTotal(total);
		return fenye;
	}

	@Override
	public Integer selectCountBylname(String u_loginName) {
		// TODO Auto-generated method stub

		String string2md5 = MD5Util.string2MD5(u_loginName);

		return userMapper.selectCountByLname(string2md5);
	}

	@Override
	public Integer insertUser(User user) {
		// TODO Auto-generated method stub
		String u_loginName = user.getU_loginName();
		String string2md5 = MD5Util.string2MD5(u_loginName);
		user.setU_loginName(string2md5);
		
		Integer j=userMapper.selectUserisok(user.getU_userName());
		Integer pd=0;
		if(j==0) {
			Integer i=userMapper.insertUser(user);
			if(i>0) {
				pd=1;
			}
				else {
				pd=2;
				}
		}
		else {
			pd=3;
		}

		return pd;
	}

	@Override
	public Integer deleteUser(Integer u_id) {
		// TODO Auto-generated method stub
		Integer jg=0;
		Integer isorno = userMapper.selectStudentOfUser(u_id);
		if(isorno>0) {
			Integer i = userMapper.deleteUser(u_id);
			if(i>0) {
				jg=3;
			}else {
				jg=2;
			}
		}else {
			jg=1;
		}
		return jg;
	}

	@Override
	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}

	@Override
	public Integer chongzhimima(Integer u_id) {
		// TODO Auto-generated method stub
		return userMapper.chongzhimima(u_id);
	}

	@Override
	public Integer suoding(Integer u_id) {
		// TODO Auto-generated method stub
		return userMapper.suoding(u_id);
	}

	@Override
	public Integer jiesuo(Integer u_id) {
		// TODO Auto-generated method stub
		return userMapper.jiesuo(u_id);
	}

	@Override
	public List<Role> selectRole() {
		// TODO Auto-generated method stub
		return userMapper.selectRole();
	}

	@Override
	public List<Role> selectMyRole(Integer u_id) {
		// TODO Auto-generated method stub
		return userMapper.selectMyRole(u_id);
	}

	@Override
	public Integer insertRole(UserRole userRole) {
		// TODO Auto-generated method stub
		return userMapper.addRoles(userRole);
	}

	@Override
	public Integer deleteRole(UserRole userRole) {
		// TODO Auto-generated method stub
		return userMapper.deleteRole(userRole);
	}

	@Override
	public Integer updateLastTime(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateLastTime(user);
	}

	@Override
	public Integer updateMima(User user, HttpServletRequest request) {
		// TODO Auto-generated method stub

		user.setOpwd(MD5Util.string2MD5(user.getOpwd()));
		user.setApwd(MD5Util.string2MD5(user.getApwd()));
		user.setNpwd(MD5Util.string2MD5(user.getNpwd()));
		Integer jg = 0;
		User user1 = (User) request.getSession().getAttribute("usera");
		user.setU_id(user1.getU_id());  //获取用户的编号
		String yanzhengma = (String) request.getSession().getAttribute("suijiNum"); //获取发送给手机的验证码
		String abc = user.getU_phoneNumber();//获取用户输入的手机号码
		 String u_phoneNumber = user1.getU_phoneNumber();//获取用户绑定的手机号码
		
		if (user.getYanzheng().equals(yanzhengma)) { //判断验证码是否正确
			 if(u_phoneNumber.equals(abc)) {//判断手机号是否为当前用户绑定的手机号
			if (user.getOpwd().equals(user1.getU_password())) {//判断旧密码是否正确
				if (user.getApwd().equals(user.getNpwd())) {//判断两次输入的密码是否相同
					if (userMapper.updateMima(user) > 0) {//判断修改密码是否成功
						return jg = 4;
					} else {
						return jg = 3;
					}
				} else {
					return jg = 2;
				} 
			} else {
				return jg = 1;
			}
		} else {
			return jg=6;
		}
		} else {
			return jg = 5;
		}
	}
	@Override
	public Fenye<User> selectUserQD(Fenye<User> fenye) {
		// TODO Auto-generated method stub
		List<User> rows = userMapper.selectUserQD(fenye);
		Integer total = userMapper.selectCountQD(fenye);
		fenye.setRows(rows);
		fenye.setTotal(total);
		return fenye;
	}

	@Override
	public Integer updaetQD(Integer u_id) {
		// TODO Auto-generated method stub
		Integer jg = 0;
		User qd = userMapper.selectStatusQD(u_id);
		User qd2=userMapper.selectStatusintwo(u_id);
		if(qd2==null) {
			if (qd == null) {
				if (userMapper.qdcaozuo(u_id) > 0) {
					return jg = 3;
				} else {
					return jg = 2;
				}
			} else {
				return jg = 1;
			}
		}else {
			return jg=4;
		}
		
	}

	@Override
	public Integer updateAllemp() {
		// TODO Auto-generated method stub

		Integer qiantui = userMapper.qiantui();
		return qiantui;
	}

	@Override
	public List<User> selectZixs() {
		// TODO Auto-generated method stub
		return userMapper.selectZxs();
	}

	@Override
	public Fenye<User> selectWeight(Fenye<User> fenye) {
		// TODO Auto-generated method stub
		List<User> rows = userMapper.selectUweight(fenye);
		Integer total = userMapper.selectUweightCount(fenye);
		fenye.setTotal(total);
		fenye.setRows(rows);
		return fenye;
	}

	@Override
	public Integer updateUweight(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUweight(user);
	}

	@Override
	public Integer updateIsFenpei(IsFenpei isfenpei) {
		// TODO Auto-generated method stub
		Integer jg = 0;
		Integer a = userMapper.updateIsFenpei(isfenpei);
		if (a > 0) {
			if (studentMapper.isORnot().getFenpei() == 1) {
				jg = 3;
			} else {
				jg = 2;
			}
		} else {
			jg = 1;
		}
		System.out.println(jg);
		return jg;
	}

	@Override
	public Integer selectIsORNot() {
		// TODO Auto-generated method stub
		Integer fenpei = studentMapper.isORnot().getFenpei();
		return fenpei;
	}

	

}
