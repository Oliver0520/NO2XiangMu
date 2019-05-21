package com.xz.dao;

import java.util.List;

import com.xz.entity.Fenye;
import com.xz.entity.IsFenpei;
import com.xz.entity.Student;
import com.xz.entity.User;


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
/**
 * ��ѯ��ѯʦ����
 * @param s_id
 * @return
 */
String selectname(Integer s_id);
/**
 * ��ѯ������ѯʦ����
 * @param s_id
 * @return
 */
String selectname2(Integer s_id);
/**
 * ��ѯ��ɫΪ��ѯʦ��ɫ����Ϣ
 * @return
 */
List<User> selectUname();

Integer selectjs(Integer u_id);

Integer selectjs1(Integer u_id);
Integer selectjs2(Integer u_id);

List<Student> selectMyStudent (Fenye<Student> fenye);

Integer countselectzxjs(Fenye<Student> fenye);
/**
 * ��ѯδ��������ѯʦ��ѧ��
 * @param fenye
 * @return
 */
List<Student> selectFenpei(Fenye<Student> fenye);
/**
 * ��ѯδ��������ѯʦ������
 * @param fenye
 * @return
 */
Integer selectFenpeiCount(Fenye<Student> fenye);
/**
 * �ֶ�����
 * @param student
 * @return
 */
Integer fenpeizx(Student student);

IsFenpei isORnot();
}
