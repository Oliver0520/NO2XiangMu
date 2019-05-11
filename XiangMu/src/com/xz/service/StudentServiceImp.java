package com.xz.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.jasper.tagplugins.jstl.core.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xz.dao.StudentMapper;
import com.xz.entity.Fenye;
import com.xz.entity.Student;
import com.xz.entity.User;
@Service
public class StudentServiceImp implements StudentService{
@Autowired
private StudentMapper studentMapper;

	@Override
	public Fenye<Student> getStudent(Fenye<Student> fenye) {
		// TODO Auto-generated method stub
		Integer countStu = studentMapper.selectCountStu(fenye);
		List<Student> student = studentMapper.selectStudent(fenye);
		for(int i=0;i<student.size();i++) {
			Integer s_id=student.get(i).getS_id();
			String name = studentMapper.selectname(s_id);
		    student.get(i).setName(name);
			String name2 = studentMapper.selectname2(s_id);
			student.get(i).setName2(name2);
		}		
		fenye.setTotal(countStu);
		fenye.setRows(student);
		return fenye;
	}
	@Override
	public Integer deleteStudent(Integer s_id) {
		// TODO Auto-generated method stub
		return studentMapper.deleteStudent(s_id);
	}

	@Override
	public List<User> selectUname() {
		// TODO Auto-generated method stub
		return studentMapper.selectUname();
	}



}
