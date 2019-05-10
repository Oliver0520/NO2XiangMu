package com.xz.entity;

import org.springframework.stereotype.Component;

@Component
public class Role {
	private Integer r_id;
	private String r_name;
	private Integer r_int;
	private String r_string;
	public Integer getR_id() {
		return r_id;
	}
	public void setR_id(Integer r_id) {
		this.r_id = r_id;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public Integer getR_int() {
		return r_int;
	}
	public void setR_int(Integer r_int) {
		this.r_int = r_int;
	}
	public String getR_string() {
		return r_string;
	}
	public void setR_string(String r_string) {
		this.r_string = r_string;
	}
	@Override
	public String toString() {
		return "Role [r_id=" + r_id + ", r_name=" + r_name + ", r_int=" + r_int + ", r_string=" + r_string + "]";
	}
	
}
