package com.xz.dao;

import java.util.List;

import com.xz.entity.Fenye;
import com.xz.entity.Logo;
import com.xz.entity.Student;

public interface LogoMapper {
	/**
	 * 分页多条件查询日志
	 * 
	 * @param fenye
	 * @return
	 */
<<<<<<< HEAD
	List<Logo> selectLogo(Fenye<Logo> fenye);


	/**
	 * 分页查询总条数
	 * 
	 * @param fenye
	 * @return
	 */
	Integer selectCount(Fenye<Logo> fenye);

	/**
	 * 添加日志
	 * 
	 * @param logo
	 * @return
	 */
	Integer insertLogo(Logo logo);

	/**
	 * 根据学生ID查询学生姓名
	 * 
	 * @param s_id
	 * @return
	 */
	String selectzrname(Integer s_id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	String selectstudentname(Integer s_id);
	String selectusername(Integer u_id);
	
	
	
	List<Logo> selectLogo1(Fenye<Logo> fenye ); 
	Integer selectCountLogo1(Fenye<Logo> fenye);

	
=======
List<Logo> selectLogo(Fenye<Logo> fenye );
/**
 * 分页查询总条数
 * @param fenye
 * @return
 */
Integer selectCount(Fenye<Logo> fenye);
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






>>>>>>> 209e21270d304639f06ee1196a861af710e7b6f3
}
