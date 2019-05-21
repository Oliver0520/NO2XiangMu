package com.xz.dao;

import java.util.List;

import com.xz.entity.Fenye;
import com.xz.entity.IsFenpei;
import com.xz.entity.Student;
import com.xz.entity.User;


public interface StudentMapper {
	/**
	 * 多条件分页查询
	 * @param fenye
	 * @return
	 */
List<Student> selectStudent (Fenye<Student> fenye);
/**
 * 分页查询总条数
 * @param fenye
 * @return
 */
Integer selectCountStu(Fenye<Student> fenye);
/**
 * 修改学生信息
 * @param student
 * @return
 */
Integer updateStudent(Student student);
/**
 * 添加学生信息
 * @param student
 * @return
 */
Integer insertStudent(Student student);
/**
 * 删除学生信息
 * @param s_id
 * @return
 */
Integer deleteStudent(Integer s_id);
/**
 * 查询咨询师姓名
 * @param s_id
 * @return
 */
String selectname(Integer s_id);
/**
 * 查询网络咨询师姓名
 * @param s_id
 * @return
 */
String selectname2(Integer s_id);
/**
 * 查询角色为咨询师角色的信息
 * @return
 */
List<User> selectUname();

Integer selectjs(Integer u_id);

Integer selectjs1(Integer u_id);
Integer selectjs2(Integer u_id);

List<Student> selectMyStudent (Fenye<Student> fenye);

Integer countselectzxjs(Fenye<Student> fenye);
/**
 * 查询未被分配咨询师的学生
 * @param fenye
 * @return
 */
List<Student> selectFenpei(Fenye<Student> fenye);
/**
 * 查询未被分配咨询师的条数
 * @param fenye
 * @return
 */
Integer selectFenpeiCount(Fenye<Student> fenye);
/**
 * 手动分配
 * @param student
 * @return
 */
Integer fenpeizx(Student student);

IsFenpei isORnot();
}
