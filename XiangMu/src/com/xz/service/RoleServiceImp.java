package com.xz.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xz.dao.RolesMapper;
import com.xz.entity.Fenye;
import com.xz.entity.Role;
@Service
public class RoleServiceImp implements RoleService {
	@Resource
    private RolesMapper roleMapper;
	@Override
	public Fenye<Role> selectAll(Fenye<Role> fenye) {
		// TODO Auto-generated method stub
		Integer total = roleMapper.selectCount();
		List<Role> rows = roleMapper.selectRoleAll(fenye);
		fenye.setTotal(total);
		fenye.setRows(rows);
		return fenye;
	}

}
