package com.xz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xz.dao.LogoMapper;
import com.xz.entity.Fenye;
import com.xz.entity.Logo;

@Service
public class LogoServiceImp implements LogoService {
	@Autowired
	private LogoMapper logomapper;
	@Override
	public Fenye<Logo> gettLogo(Fenye<Logo> fenye) {
		// TODO Auto-generated method stub
		Integer countStu = logomapper.selectCount(fenye);
		List<Logo> logo = logomapper.selectLogo(fenye);
		//ѭ����ѯѧ��ID��ͨ��ѧ��ID�ֱ�ȥ���Ӧ��ѧ���������ٰѲ�ѯ����ѧ������Set��ѧ��ID��
		for (int i = 0; i < logo.size(); i++) {
			Integer s_id = logo.get(i).getS_id();
			String name = logomapper.selectzrname(s_id);
			logo.get(i).setRzname(name);
		}
		fenye.setRows(logo);
		fenye.setTotal(countStu);
		return fenye;
	}

	@Override
	public Integer insertLogo(Logo logo) {
		// TODO Auto-generated method stub
		return logomapper.insertLogo(logo);
	}

	@Override
	public Integer selectCounut(Fenye<Logo> fenye) {
		// TODO Auto-generated method stub
		return logomapper.selectCount(fenye);
	}

	@Override
	public String selectzrname(Integer s_id) {
		// TODO Auto-generated method stub
		return logomapper.selectzrname(s_id);
	}

}