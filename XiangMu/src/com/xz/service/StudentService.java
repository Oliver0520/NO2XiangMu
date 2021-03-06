package com.xz.service;


import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xz.entity.Fenye;
import com.xz.entity.Student;
import com.xz.entity.User;
public interface StudentService {
	/**
	 * 分页多条件查询数据
	 * @param fenye
	 * @return
	 */
Fenye<Student> getStudent(Fenye<Student> fenye) throws ParseException;
/**
 * 删除学生信息
 * @param s_id
 * @return
 */
Integer deleteStudent (Integer s_id);
/**
 * 查询角色为咨询师角色的信息
 * @return
 */
List<User> selectUname();
/**
 * 修改学生信息
 * @param student
 * @return
 */
Integer updateStudent(Student student);

	/* String selectname(Integer s_id); */
/**
 * 添加学生信息
 * @param student
 * @return
 */
Integer insertStudent(Student student);

/**
 * 查询咨询师角色在该用户角色中的数量
 * @param u_id
 * @return
 */
Integer selectjs(Integer u_id);
/**
 * 查询咨询师经理角色在该用户角色中的数量
 * @param u_id
 * @return
 */

Integer selectjs1(Integer u_id);
/**
 * 查询管理员角色在该用户角色中的数量
 * @param u_id
 * @return
 */
Integer selectjs2(Integer u_id);
/**
 * 查询网络咨询师角色在该用户角色中的数量
 * @param u_id
 * @return
 */
Integer selectjs3(Integer u_id);

Fenye<Student> getzxjs(Fenye<Student> fenye);


Fenye<Student> selectFenpei(Fenye<Student> fenye);

Integer fenpeizx(Student student);
void daochuexcel(HttpServletRequest request,HttpServletResponse response,String s_ids) throws IOException;


}
