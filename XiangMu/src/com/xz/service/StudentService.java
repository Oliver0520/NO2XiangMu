package com.xz.service;


import java.util.List;



import com.xz.entity.Fenye;
import com.xz.entity.Student;
import com.xz.entity.User;
public interface StudentService {
	/**
	 * 分页多条件查询数据
	 * @param fenye
	 * @return
	 */
Fenye<Student> getStudent(Fenye<Student> fenye);
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

Integer selectjs(Integer u_id);

Integer selectjs1(Integer u_id);

Fenye<Student> getzxjs(Fenye<Student> fenye);

}
