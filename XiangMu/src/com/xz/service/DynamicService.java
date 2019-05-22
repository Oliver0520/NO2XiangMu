package com.xz.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xz.entity.Dynamic;
import com.xz.entity.Fenye;

public interface DynamicService {
	/**
	 * ���Ͷ�̬
	 * @param dynamic
	 * @param request
	 * @return
	 */
Integer SendDynamic(Dynamic dynamic,HttpServletRequest request);
/**
 * ���ն�̬��Ϣ
 * @param fenye
 * @return
 */
Fenye<Dynamic> CopyDynamic(Fenye<Dynamic> fenye);
/**
 * ��ѯδ������
 * @param request
 * @return
 */
Integer copyDynamicCount(HttpServletRequest request);
/**
 * ���Ϊ�Ѷ�
 * @param d_id
 * @return
 */
Integer updateBit(Integer d_id);
}
