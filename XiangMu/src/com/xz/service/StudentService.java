package com.xz.service;


import java.util.List;

import com.xz.entity.Fenye;
import com.xz.entity.Student;
import com.xz.entity.User;
public interface StudentService {
Fenye<Student> getStudent(Fenye<Student> fenye);
Integer deleteStudent (Integer s_id);
/**
 * ��ѯ��ɫΪ��ѯʦ��ɫ����Ϣ
 * @return
 */
List<User> selectUname();
}
