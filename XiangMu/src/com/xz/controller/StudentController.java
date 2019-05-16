package com.xz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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

	@RequestMapping(value = "/MyStudent")
	private String MyStudent(HttpServletRequest Request) {
		User user = (User) Request.getSession().getAttribute("usera");
		Integer i = studentService.selectjs(user.getU_id());
		Integer j = studentService.selectjs1(user.getU_id());
		Request.getSession().setAttribute("zx", i);
		Request.getSession().setAttribute("zxgl", j);
		return "MyStudent";
	}
	@RequestMapping(value = "/StudentList")
	private String StudentList(HttpServletRequest Request) {
		User user = (User) Request.getSession().getAttribute("usera");
		Integer i = studentService.selectjs(user.getU_id());
		Integer j = studentService.selectjs1(user.getU_id());
		Request.getSession().setAttribute("zx", i);
		Request.getSession().setAttribute("zxgl", j);
		return "StudentList";
	}

	@RequestMapping(value = "/chaxunasd", method = RequestMethod.POST)
	@ResponseBody
	public Fenye<Student> getStudent(Integer page, Integer rows, Student student, HttpServletRequest Request) {
		fenye.setPage((page - 1) * rows);
		fenye.setPageSize(rows);
		fenye.setT(student);
		User user = (User) Request.getSession().getAttribute("usera");
		Integer i = studentService.selectjs(user.getU_id());
		Integer j = studentService.selectjs1(user.getU_id());

		if (j > 0) {

			fenye = studentService.getStudent(fenye);
		} else {
			if (i > 0) {
				student.setU_id(user.getU_id());
				fenye = studentService.getzxjs(fenye);
			}
		}

		return fenye;
	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
	@ResponseBody
	public Integer deleteStudent(Integer s_id) {
		return studentService.deleteStudent(s_id);
	}

	@RequestMapping(value = "/selectUname", method = RequestMethod.POST)
	@ResponseBody
	public List<User> selectUname() {
		return studentService.selectUname();
	}

	@RequestMapping(value = "/updaStu", method = RequestMethod.POST)
	@ResponseBody
	public Integer updateStudent(Student student) {
		int i = studentService.updateStudent(student);

		return i;
	}

	@RequestMapping(value = "/insertStudent", method = RequestMethod.POST)
	@ResponseBody
	public Integer insertStudent(Student student) {
		int i = studentService.insertStudent(student);
		return i;
	}
	/*
	 * @RequestMapping(value="/selectname",method=RequestMethod.POST)
	 * 
	 * @ResponseBody public String selectname(Integer s_id) { String
	 * i=studentService.selectname(s_id); return i; }
	 */
	@RequestMapping(value="/selectFenpei",method=RequestMethod.POST)
	@ResponseBody
    public Fenye<Student> selectFenpei(Student student,Integer page,Integer rows) {
    	fenye.setPage((page-1)*rows);
    	fenye.setPageSize(rows);
    	fenye.setT(student);
    	return fenye;
    }
	@RequestMapping(value="/Fenpei")
	public String Fenpei() {
		return "Fenpei";
	}
}
