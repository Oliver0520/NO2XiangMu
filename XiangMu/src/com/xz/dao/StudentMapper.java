package com.xz.dao;

import java.util.List;

import com.xz.entity.Fenye;
import com.xz.entity.Student;


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
}
