package com.xz.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Set;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
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
	   List<User> zxs = userMapper.selectZxsFenpei();
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
	public Integer selectjs2(Integer u_id) {
		// TODO Auto-generated method stub
		return studentMapper.selectjs2(u_id);
	}
	@Override
	public Integer selectjs3(Integer u_id) {
		// TODO Auto-generated method stub
		return studentMapper.selectjs3(u_id);
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
		Integer total = studentMapper.selectFenpeiCount(fenye);
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
	public void daochuexcel(HttpServletRequest request, HttpServletResponse response, String s_ids) throws IOException {
		// TODO Auto-generated method stub
		String[] split = s_ids.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < split.length; i++) {
			list.add(Integer.parseInt(split[i]));
		}
		List<Student> studentlist = studentMapper.selectStudent_xuanzhong(list);
		for (int i = 0; i < studentlist.size(); i++) {
			User name = studentMapper.selectUseru_id(studentlist.get(i).getU_id());
			User name2 = studentMapper.selectUseru_id(studentlist.get(i).getU_id());
			studentlist.get(i).setU_id(name.getU_id());
			studentlist.get(i).setU_id(name2.getU_id());
		}

		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wkb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wkb.createSheet("学生信息");
		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue("学生信息");
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		// 在sheet里创建第二行

		HSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		/*
		 * row2.createCell(0).setCellValue("sj_id");
		 * row2.createCell(1).setCellValue("sj_name");
		 * row2.createCell(2).setCellValue("sj_jage");
		 * row2.createCell(3).setCellValue("sj_zuozhe");
		 */

		String columnStr = "姓名，年龄，性别，电话，学历，状态，来源渠道，来源网站，来源关键字，"+ "qq，微信，是否报备，备注，咨询师，所在区域，来源部门，课程方向，是否有效，打分，" + "是否回访，首次回访时间，是否上门，上门时间，无效原因，是否缴费，缴费时间，金额，是否退费，"
				+ "是否进班，进班时间，进班备注，退费原因，定金金额，定金时间，学生关注，网络咨询师，咨询师备注，录入人";
		String[] heads = columnStr.split("，");
		for (int i = 0; i < heads.length; i++) {
			row2.createCell(i).setCellValue("" + heads[i] + "");
		}
		for (int i = 0; i < studentlist.size(); i++) {
			HSSFRow row3 = sheet.createRow(i + 2);
			Student stu = studentlist.get(i);
			/* System.out.println(stu.getS_string()+"...."); */
			row3.createCell(0).setCellValue(stu.getS_name() == null ? "" : stu.getS_name());
			row3.createCell(1).setCellValue(stu.getS_sex() == null ? "" : (stu.getS_sex() == 1 ? "男" : "女"));
			row3.createCell(2).setCellValue(stu.getS_age() == null ? "" : "" + stu.getS_age());
			row3.createCell(3).setCellValue(stu.getS_phone() == null ? "" : stu.getS_phone());
			row3.createCell(4).setCellValue(stu.getS_education() == null ? "" : stu.getS_education());
			row3.createCell(5).setCellValue(stu.getS_status() == null ? "" : stu.getS_status());
			row3.createCell(6).setCellValue(stu.getS_qudao() == null ? "" : stu.getS_qudao());
			row3.createCell(7).setCellValue(stu.getS_wangzhan() == null ? "" : stu.getS_wangzhan());
			row3.createCell(8).setCellValue(stu.getS_guanjian() == null ? "" : stu.getS_guanjian());
			row3.createCell(9).setCellValue(stu.getS_qq() == null ? "" : stu.getS_qq());
			row3.createCell(10).setCellValue(stu.getS_weChat() == null ? "" : stu.getS_weChat());
			row3.createCell(11).setCellValue(stu.getS_baobei() == null ? "" : (stu.getS_baobei() == 2 ? "是" : "否"));
			row3.createCell(12).setCellValue(stu.getS_beizhu() == null ? "" : stu.getS_beizhu());
			row3.createCell(13).setCellValue(stu.getName() == null ? "暂无咨询师" : stu.getName());
			row3.createCell(14).setCellValue(stu.getS_quyu() == null ? "" : stu.getS_quyu());
			row3.createCell(15).setCellValue(stu.getS_bumen() == null ? "" : stu.getS_bumen());
			row3.createCell(16).setCellValue(stu.getS_kecheng() == null ? "" : stu.getS_kecheng());
			row3.createCell(17).setCellValue(stu.getS_youxiao() == null ? "" : (stu.getS_youxiao() == 2 ? "是" : "否"));
			row3.createCell(18).setCellValue(stu.getS_dafen()==null ? 0 :stu.getS_dafen());
			row3.createCell(19).setCellValue(stu.getS_huifang() == null ? "" : (stu.getS_huifang() == 2 ? "是" : "否"));
			row3.createCell(20).setCellValue(stu.getS_huifangshijian() == null ? "" : stu.getS_huifangshijian());
			row3.createCell(21).setCellValue(stu.getS_shangmen()== null ? "" : (stu.getS_shangmen() == 2 ? "是" : "否"));
			row3.createCell(22).setCellValue(stu.getS_shangmenshijian() == null ? "" : stu.getS_shangmenshijian());
			row3.createCell(23).setCellValue(stu.getS_wuxiaoyuanyin() == null ? "" : stu.getS_wuxiaoyuanyin());
			row3.createCell(24).setCellValue(stu.getS_jiaofei() == null ? "" : (stu.getS_jiaofei() == 2 ? "是" : "否"));
			row3.createCell(25).setCellValue(stu.getS_jiaofeishijian() == null ? "" : stu.getS_jiaofeishijian());
			row3.createCell(26).setCellValue(stu.getS_price() == null ? 0 : stu.getS_price());
			row3.createCell(27).setCellValue(stu.getS_tuifei() == null ? "" : (stu.getS_tuifei() == 2 ? "是" : "否"));
			row3.createCell(28).setCellValue(stu.getS_jinban() == null ? "" : (stu.getS_jinban() == 2 ? "是" : "否"));
			row3.createCell(29).setCellValue(stu.getS_jinbanshijian() == null ? "" : stu.getS_jinbanshijian());
			row3.createCell(30).setCellValue(stu.getS_jinbanbeizhu() == null ? "" : stu.getS_jinbanbeizhu());
			row3.createCell(31).setCellValue(stu.getS_tuifeiyuanyin() == null ? "" : stu.getS_tuifeiyuanyin());
			row3.createCell(32).setCellValue(stu.getS_dingjin() == null ? 0 : stu.getS_dingjin());
			row3.createCell(33).setCellValue(stu.getS_dingjinshijian() == null ? "" : stu.getS_dingjinshijian());
			row3.createCell(34).setCellValue(stu.getS_guanzhu() == null ? "" : stu.getS_guanzhu());
			row3.createCell(35).setCellValue(stu.getName2() == null ? "暂无面见咨询师" : stu.getName2());
			row3.createCell(36).setCellValue(stu.getS_zixunbeizhu() == null ? "" : stu.getS_zixunbeizhu());
			row3.createCell(37).setCellValue(stu.getS_string()== null ? "暂无录入人" : stu.getS_string());
		}
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename="+new String("学生信息.xls".getBytes("GB2312"),"ISO8859-1"));
		response.setContentType("application/msexcel");
		wkb.write(output);
		output.close();
		
	}




}
