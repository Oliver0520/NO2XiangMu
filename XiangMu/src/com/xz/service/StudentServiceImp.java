package com.xz.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.jasper.tagplugins.jstl.core.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.xz.dao.StudentMapper;
import com.xz.dao.UserMapper;
import com.xz.entity.Fenye;
import com.xz.entity.Student;
import com.xz.entity.User;
import com.xz.fujie.FenPei;

@Service
public class StudentServiceImp implements StudentService {
	@Autowired
	private StudentMapper studentMapper;
    @Autowired
	private UserMapper userMapper;
	@Override
	public Fenye<Student> getStudent(Fenye<Student> fenye) {
		// TODO Auto-generated method stub
		Integer countStu = studentMapper.selectCountStu(fenye);
		List<Student> student = studentMapper.selectStudent(fenye);
		//循环查询学生ID，通过学生ID分别去查对应的咨询师姓名，再把查询出的咨询师姓名Set进学生ID里
		for (int i = 0; i < student.size(); i++) {
			Integer s_id = student.get(i).getS_id();
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

	@Override
	public Integer updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.updateStudent(student);
	}

	@Override
	public Integer insertStudent(Student student) {
		// TODO Auto-generated method stub
	   List<User> zxs = userMapper.selectZxs();
	   User fenpei = FenPei.fenpei(zxs);
	   Integer u_id = fenpei.getU_id();
	   if(studentMapper.isORnot().getFenpei()==2) {
	   student.setU_id(u_id);}
		return studentMapper.insertStudent(student);
	}

	@Override
	public Integer selectjs(Integer u_id) {
		// TODO Auto-generated method stub
		return studentMapper.selectjs(u_id);
	}

	@Override
	public Integer selectjs1(Integer u_id) {
		// TODO Auto-generated method stub
		return studentMapper.selectjs1(u_id);
	}

	@Override
	public Fenye<Student> getzxjs(Fenye<Student> fenye) {
		// TODO Auto-generated method stub
		Integer countStu = studentMapper.countselectzxjs(fenye);
		List<Student> student = studentMapper.selectMyStudent(fenye);
		for (int i = 0; i < student.size(); i++) {
			Integer s_id = student.get(i).getS_id();
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
	public Fenye<Student> selectFenpei(Fenye<Student> fenye) {
		// TODO Auto-generated method stub
		List<Student> rows = studentMapper.selectFenpei(fenye);
		Integer total = studentMapper.selectCountStu(fenye);
		fenye.setRows(rows);
		fenye.setTotal(total);
		return fenye;
	}

	@Override
	public Integer fenpeizx(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.fenpeizx(student);
	}

	@Override
	public Integer selectjs2(Integer u_id) {
		// TODO Auto-generated method stub
		return studentMapper.selectjs2(u_id);
	}



	

	

	

	/*
	 * @Override public String selectname(Integer s_id) { // TODO Auto-generated
	 * method stub return studentMapper.selectname(s_id); }
	 */

}
