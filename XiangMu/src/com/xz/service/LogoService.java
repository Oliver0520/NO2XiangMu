package com.xz.service;

import com.xz.entity.Fenye;
import com.xz.entity.Logo;
import com.xz.entity.Student;
public interface LogoService {
	/**
	 * ��ҳ��������ѯѧ����Ϣ
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
 * �����־
 * @param logo
 * @return
 */
Integer insertLogo(Logo logo);
/**
 * ����ѧ��ID��ѯѧ������
 * @param s_id
 * @return
 */
String selectzrname(Integer s_id);


Fenye<Logo> getLogo1(Fenye<Logo> fenye);




}
