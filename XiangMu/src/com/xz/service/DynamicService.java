package com.xz.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xz.entity.Dynamic;
import com.xz.entity.Fenye;

public interface DynamicService {
	/**
	 * 发送动态
	 * @param dynamic
	 * @param request
	 * @return
	 */
Integer SendDynamic(Dynamic dynamic,HttpServletRequest request);
/**
 * 接收动态信息
 * @param fenye
 * @return
 */
Fenye<Dynamic> CopyDynamic(Fenye<Dynamic> fenye);
/**
 * 查询未读条数
 * @param request
 * @return
 */
Integer copyDynamicCount(HttpServletRequest request);
/**
 * 标记为已读
 * @param d_id
 * @return
 */
Integer updateBit(Integer d_id);
}
