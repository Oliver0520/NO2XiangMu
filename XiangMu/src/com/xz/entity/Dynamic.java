package com.xz.entity;

import org.springframework.stereotype.Component;

@Component
public class Dynamic {

	private Integer d_id;
	private String s_name;
	private String u_nameSend;
	private String d_sendTime;
	private Integer u_nameCopy;
	private String d_body;
	private Integer d_bit;
	private Integer d_int;
	private String d_string;
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getU_nameSend() {
		return u_nameSend;
	}
	public void setU_nameSend(String u_nameSend) {
		this.u_nameSend = u_nameSend;
	}
	public String getD_sendTime() {
		return d_sendTime;
	}
	public void setD_sendTime(String d_sendTime) {
		this.d_sendTime = d_sendTime;
	}
	public String getD_body() {
		return d_body;
	}
	public void setD_body(String d_body) {
		this.d_body = d_body;
	}
	public Integer getD_bit() {
		return d_bit;
	}
	public void setD_bit(Integer d_bit) {
		this.d_bit = d_bit;
	}
	public Integer getD_int() {
		return d_int;
	}
	public void setD_int(Integer d_int) {
		this.d_int = d_int;
	}
	public String getD_string() {
		return d_string;
	}
	public void setD_string(String d_string) {
		this.d_string = d_string;
	}
	public Integer getU_nameCopy() {
		return u_nameCopy;
	}
	public void setU_nameCopy(Integer u_nameCopy) {
		this.u_nameCopy = u_nameCopy;
	}
	@Override
	public String toString() {
		return "Dynamic [d_id=" + d_id + ", s_name=" + s_name + ", u_nameSend=" + u_nameSend + ", d_sendTime="
				+ d_sendTime + ", u_nameCopy=" + u_nameCopy + ", d_body=" + d_body + ", d_bit=" + d_bit + ", d_int="
				+ d_int + ", d_string=" + d_string + "]";
	}
	private Integer s_id;
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	private String uname;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
}
