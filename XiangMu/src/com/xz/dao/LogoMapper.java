package com.xz.dao;

import java.util.List;

import com.xz.entity.Fenye;
import com.xz.entity.Logo;
import com.xz.entity.Student;

public interface LogoMapper {
	/**
	 * ��ҳ��������ѯ��־
	 * 
	 * @param fenye
	 * @return
	 */

	List<Logo> selectLogo(Fenye<Logo> fenye);


	/**
	 * ��ҳ��ѯ������
	 * 
	 * @param fenye
	 * @return
	 */
	Integer selectCount(Fenye<Logo> fenye);

	/**
	 * �����־
	 * 
	 * @param logo
	 * @return
	 */
	Integer insertLogo(Logo logo);

	/**
	 * ����ѧ��ID��ѯѧ������
	 * 
	 * @param s_id
	 * @return
	 */
	String selectzrname(Integer s_id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	String selectstudentname(Integer s_id);
	String selectusername(Integer u_id);
	
	
	
	List<Logo> selectLogo1(Fenye<Logo> fenye ); 
	Integer selectCountLogo1(Fenye<Logo> fenye);

	






}
