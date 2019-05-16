package com.xz.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.jasper.tagplugins.jstl.core.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.xz.dao.StudentMapper;
import com.xz.entity.Fenye;
import com.xz.entity.Student;
import com.xz.entity.User;

@Service
public class StudentServiceImp implements StudentService {
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public Fenye<Student> getStudent(Fenye<Student> fenye) {
		// TODO Auto-generated method stub
		Integer countStu = studentMapper.selectCountStu(fenye);
		List<Student> student = studentMapper.selectStudent(fenye);
		//ѭ����ѯѧ��ID��ͨ��ѧ��ID�ֱ�ȥ���Ӧ����ѯʦ�������ٰѲ�ѯ������ѯʦ����Set��ѧ��ID��
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
		fenye.setTotal(countStu);
		fenye.setRows(student);
		return fenye;
	}



	

	

	

	/*
	 * @Override public String selectname(Integer s_id) { // TODO Auto-generated
	 * method stub return studentMapper.selectname(s_id); }
	 */

}