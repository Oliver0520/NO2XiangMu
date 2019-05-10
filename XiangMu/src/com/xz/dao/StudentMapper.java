package com.xz.dao;

import java.util.List;

import com.xz.entity.Fenye;
import com.xz.entity.Student;


public interface StudentMapper {
	/**
	 * ��������ҳ��ѯ
	 * @param fenye
	 * @return
	 */
List<Student> selectStudent (Fenye<Student> fenye);
/**
 * ��ҳ��ѯ������
 * @param fenye
 * @return
 */
Integer selectCountStu(Fenye<Student> fenye);
/**
 * �޸�ѧ����Ϣ
 * @param student
 * @return
 */
Integer updateStudent(Student student);
/**
 * ���ѧ����Ϣ
 * @param student
 * @return
 */
Integer insertStudent(Student student);
/**
 * ɾ��ѧ����Ϣ
 * @param s_id
 * @return
 */
Integer deleteStudent(Integer s_id);
}
