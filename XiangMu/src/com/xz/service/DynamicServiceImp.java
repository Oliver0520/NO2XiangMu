package com.xz.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.xz.dao.DynamicMapper;
import com.xz.entity.Dynamic;
import com.xz.entity.Fenye;
import com.xz.entity.User;
@Service
public class DynamicServiceImp implements DynamicService {
     @Resource
	private DynamicMapper dynamicMapper;
     @Resource
     private Dynamic dynamic;
	@Override
	public Integer SendDynamic(Dynamic dynamic,HttpServletRequest request) {
		// TODO Auto-generated method stub
		Integer jg=0;
		User user = (User) request.getSession().getAttribute("usera");
		String u_userName = user.getU_userName();
		dynamic.setU_nameSend(u_userName);
		dynamic.setD_bit(2);
		Integer uid = dynamicMapper.selectStuUid(dynamic.getS_id());
		dynamic.setU_nameCopy(uid);
		Integer i = dynamicMapper.SendDynamic(dynamic);
		if(i>0) {
			jg=2;
		}else {
			jg=1;
		}
		return jg;
	}
	@Override
	public Fenye<Dynamic> CopyDynamic(Fenye<Dynamic> fenye) {
		// TODO Auto-generated method stub
		
		List<Dynamic> list = dynamicMapper.copyDynamic(fenye);
		Integer copyDynamicCount = dynamicMapper.copyDynamicCount(fenye);
		for(int i=0;i<list.size();i++ ) {
			String name = dynamicMapper.selectDyUname(list.get(i).getU_nameCopy());
			list.get(i).setUname(name);;
		}
		fenye.setRows(list);
		fenye.setTotal(copyDynamicCount);
		return fenye;
	}
	@Override
	public Integer copyDynamicCount(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Integer jg=0;
		User user = (User) request.getSession().getAttribute("usera");	
		Integer i = dynamicMapper.selectDyCount(user.getU_id());
		System.out.println(i);
		if(i!=0) {
			jg=i;
		}else {
			jg=-1;
		}
		return jg;
	}
	@Override
	public Integer updateBit(Integer d_id) {
		// TODO Auto-generated method stub
		return dynamicMapper.updateDyBit(d_id);
	}

}
