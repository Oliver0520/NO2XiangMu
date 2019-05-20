package com.xz.service;

import com.xz.entity.Fenye;
import com.xz.entity.Logo;
import com.xz.entity.Student;
public interface LogoService {
	/**
	 * 分页多条件查询学生信息
	 * @param fenye
	 * @return
	 */
Fenye<Logo> gettLogo(Fenye<Logo> fenye);
/**
 * 
 * @param fenye
 * @return
 */
Integer selectCounut(Fenye<Logo> fenye);
/**
 * 添加日志
 * @param logo
 * @return
 */
Integer insertLogo(Logo logo);
/**
 * 根据学生ID查询学生姓名
 * @param s_id
 * @return
 */
String selectzrname(Integer s_id);


Fenye<Logo> getLogo1(Fenye<Logo> fenye);




}
