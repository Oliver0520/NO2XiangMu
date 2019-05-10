package com.xz.service;


import com.xz.entity.Fenye;
import com.xz.entity.Student;
public interface StudentService {
Fenye<Student> getStudent(Fenye<Student> fenye);
Integer deleteStudent (Integer s_id);
}
