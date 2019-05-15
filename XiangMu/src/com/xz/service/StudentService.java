package com.xz.service;


import java.util.List;



import com.xz.entity.Fenye;
import com.xz.entity.Student;
import com.xz.entity.User;
public interface StudentService {
	/**
	 * ��ҳ��������ѯ����
	 * @param fenye
	 * @return
	 */
Fenye<Student> getStudent(Fenye<Student> fenye);
/**
 * ɾ��ѧ����Ϣ
 * @param s_id
 * @return
 */
Integer deleteStudent (Integer s_id);
/**
 * ��ѯ��ɫΪ��ѯʦ��ɫ����Ϣ
 * @return
 */
List<User> selectUname();
/**
 * �޸�ѧ����Ϣ
 * @param student
 * @return
 */
Integer updateStudent(Student student);

	/* String selectname(Integer s_id); */
/**
 * ���ѧ����Ϣ
 * @param student
 * @return
 */
Integer insertStudent(Student student);

Integer selectjs(Integer u_id);

Integer selectjs1(Integer u_id);

Fenye<Student> getzxjs(Fenye<Student> fenye);

}
