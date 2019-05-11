package com.xz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.entity.Fenye;
import com.xz.entity.Student;
import com.xz.entity.User;
import com.xz.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private Fenye<Student> fenye;

	@RequestMapping(value = "/chaxunasd", method = RequestMethod.POST)
	@ResponseBody
	public Fenye<Student> getStudent(Integer page, Integer rows,Student student) {
		fenye.setPage((page - 1) * rows);
		fenye.setPageSize(rows);
		fenye.setT(student);
		fenye = studentService.getStudent(fenye);
		return fenye;
	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
	@ResponseBody
	public Integer deleteStudent(Integer s_id) {
		return studentService.deleteStudent(s_id);
	}
	@RequestMapping(value="/selectUname",method=RequestMethod.POST)
	@ResponseBody
	public List<User> selectUname(){
		return studentService.selectUname();
	}
}
