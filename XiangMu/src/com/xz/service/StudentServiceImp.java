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

		// ����HSSFWorkbook����(excel���ĵ�����)
		HSSFWorkbook wkb = new HSSFWorkbook();
		// �����µ�sheet����excel�ı���
		HSSFSheet sheet = wkb.createSheet("ѧ����Ϣ");
		// ��sheet�ﴴ����һ�У�����Ϊ������(excel����)��������0��65535֮����κ�һ��
		HSSFRow row1 = sheet.createRow(0);
		// ������Ԫ��excel�ĵ�Ԫ�񣬲���Ϊ��������������0��255֮����κ�һ��
		HSSFCell cell = row1.createCell(0);
		// ���õ�Ԫ������
		cell.setCellValue("ѧ����Ϣ");
		// �ϲ���Ԫ��CellRangeAddress����������α�ʾ��ʼ�У������У���ʼ�У� ������
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		// ��sheet�ﴴ���ڶ���

		HSSFRow row2 = sheet.createRow(1);
		// ������Ԫ�����õ�Ԫ������
		/*
		 * row2.createCell(0).setCellValue("sj_id");
		 * row2.createCell(1).setCellValue("sj_name");
		 * row2.createCell(2).setCellValue("sj_jage");
		 * row2.createCell(3).setCellValue("sj_zuozhe");
		 */

		String columnStr = "���������䣬�Ա𣬵绰��ѧ����״̬����Դ��������Դ��վ����Դ�ؼ��֣�"+ "qq��΢�ţ��Ƿ񱨱�����ע����ѯʦ������������Դ���ţ��γ̷����Ƿ���Ч����֣�" + "�Ƿ�طã��״λط�ʱ�䣬�Ƿ����ţ�����ʱ�䣬��Чԭ���Ƿ�ɷѣ��ɷ�ʱ�䣬���Ƿ��˷ѣ�"
				+ "�Ƿ���࣬����ʱ�䣬���౸ע���˷�ԭ�򣬶��������ʱ�䣬ѧ����ע��������ѯʦ����ѯʦ��ע��¼����";
		String[] heads = columnStr.split("��");
		for (int i = 0; i < heads.length; i++) {
			row2.createCell(i).setCellValue("" + heads[i] + "");
		}
		for (int i = 0; i < studentlist.size(); i++) {
			HSSFRow row3 = sheet.createRow(i + 2);
			Student stu = studentlist.get(i);
			/* System.out.println(stu.getS_string()+"...."); */
			row3.createCell(0).setCellValue(stu.getS_name() == null ? "" : stu.getS_name());
			row3.createCell(1).setCellValue(stu.getS_sex() == null ? "" : (stu.getS_sex() == 1 ? "��" : "Ů"));
			row3.createCell(2).setCellValue(stu.getS_age() == null ? "" : "" + stu.getS_age());
			row3.createCell(3).setCellValue(stu.getS_phone() == null ? "" : stu.getS_phone());
			row3.createCell(4).setCellValue(stu.getS_education() == null ? "" : stu.getS_education());
			row3.createCell(5).setCellValue(stu.getS_status() == null ? "" : stu.getS_status());
			row3.createCell(6).setCellValue(stu.getS_qudao() == null ? "" : stu.getS_qudao());
			row3.createCell(7).setCellValue(stu.getS_wangzhan() == null ? "" : stu.getS_wangzhan());
			row3.createCell(8).setCellValue(stu.getS_guanjian() == null ? "" : stu.getS_guanjian());
			row3.createCell(9).setCellValue(stu.getS_qq() == null ? "" : stu.getS_qq());
			row3.createCell(10).setCellValue(stu.getS_weChat() == null ? "" : stu.getS_weChat());
			row3.createCell(11).setCellValue(stu.getS_baobei() == null ? "" : (stu.getS_baobei() == 2 ? "��" : "��"));
			row3.createCell(12).setCellValue(stu.getS_beizhu() == null ? "" : stu.getS_beizhu());
			row3.createCell(13).setCellValue(stu.getName() == null ? "������ѯʦ" : stu.getName());
			row3.createCell(14).setCellValue(stu.getS_quyu() == null ? "" : stu.getS_quyu());
			row3.createCell(15).setCellValue(stu.getS_bumen() == null ? "" : stu.getS_bumen());
			row3.createCell(16).setCellValue(stu.getS_kecheng() == null ? "" : stu.getS_kecheng());
			row3.createCell(17).setCellValue(stu.getS_youxiao() == null ? "" : (stu.getS_youxiao() == 2 ? "��" : "��"));
			row3.createCell(18).setCellValue(stu.getS_dafen()==null ? 0 :stu.getS_dafen());
			row3.createCell(19).setCellValue(stu.getS_huifang() == null ? "" : (stu.getS_huifang() == 2 ? "��" : "��"));
			row3.createCell(20).setCellValue(stu.getS_huifangshijian() == null ? "" : stu.getS_huifangshijian());
			row3.createCell(21).setCellValue(stu.getS_shangmen()== null ? "" : (stu.getS_shangmen() == 2 ? "��" : "��"));
			row3.createCell(22).setCellValue(stu.getS_shangmenshijian() == null ? "" : stu.getS_shangmenshijian());
			row3.createCell(23).setCellValue(stu.getS_wuxiaoyuanyin() == null ? "" : stu.getS_wuxiaoyuanyin());
			row3.createCell(24).setCellValue(stu.getS_jiaofei() == null ? "" : (stu.getS_jiaofei() == 2 ? "��" : "��"));
			row3.createCell(25).setCellValue(stu.getS_jiaofeishijian() == null ? "" : stu.getS_jiaofeishijian());
			row3.createCell(26).setCellValue(stu.getS_price() == null ? 0 : stu.getS_price());
			row3.createCell(27).setCellValue(stu.getS_tuifei() == null ? "" : (stu.getS_tuifei() == 2 ? "��" : "��"));
			row3.createCell(28).setCellValue(stu.getS_jinban() == null ? "" : (stu.getS_jinban() == 2 ? "��" : "��"));
			row3.createCell(29).setCellValue(stu.getS_jinbanshijian() == null ? "" : stu.getS_jinbanshijian());
			row3.createCell(30).setCellValue(stu.getS_jinbanbeizhu() == null ? "" : stu.getS_jinbanbeizhu());
			row3.createCell(31).setCellValue(stu.getS_tuifeiyuanyin() == null ? "" : stu.getS_tuifeiyuanyin());
			row3.createCell(32).setCellValue(stu.getS_dingjin() == null ? 0 : stu.getS_dingjin());
			row3.createCell(33).setCellValue(stu.getS_dingjinshijian() == null ? "" : stu.getS_dingjinshijian());
			row3.createCell(34).setCellValue(stu.getS_guanzhu() == null ? "" : stu.getS_guanzhu());
			row3.createCell(35).setCellValue(stu.getName2() == null ? "���������ѯʦ" : stu.getName2());
			row3.createCell(36).setCellValue(stu.getS_zixunbeizhu() == null ? "" : stu.getS_zixunbeizhu());
			row3.createCell(37).setCellValue(stu.getS_string()== null ? "����¼����" : stu.getS_string());
		}
		// ���Excel�ļ�
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename="+new String("ѧ����Ϣ.xls".getBytes("GB2312"),"ISO8859-1"));
		response.setContentType("application/msexcel");
		wkb.write(output);
		output.close();
		
	}




}
