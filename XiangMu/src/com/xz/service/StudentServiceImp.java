package com.xz.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xz.dao.StudentMapper;
import com.xz.entity.Fenye;
import com.xz.entity.Student;
@Service
public class StudentServiceImp implements StudentService{
@Autowired
private StudentMapper studentMapper;

	@Override
	public Fenye<Student> getStudent(Fenye<Student> fenye) {
		// TODO Auto-generated method stub
		Integer countStu = studentMapper.selectCountStu(fenye);
		List<Student> student = studentMapper.selectStudent(fenye);
		fenye.setTotal(countStu);
		fenye.setRows(student);
		return fenye;
	}

	@Override
	public Integer deleteStudent(Integer s_id) {
		// TODO Auto-generated method stub
		return studentMapper.deleteStudent(s_id);
	}



}
