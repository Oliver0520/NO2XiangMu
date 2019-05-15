package com.xz.entity;

import org.springframework.stereotype.Component;

@Component
public class UserRole {
	private Integer ur_id;
	private Integer u_id;
	private Integer r_id;
	private Integer ur_int;
	private String ur_string;
	
	public Integer getUr_id() {
		return ur_id;
	}
	public void setUr_id(Integer ur_id) {
		this.ur_id = ur_id;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public Integer getR_id() {
		return r_id;
	}
	public void setR_id(Integer r_id) {
		this.r_id = r_id;
	}
	public Integer getUr_int() {
		return ur_int;
	}
	public void setUr_int(Integer ur_int) {
		this.ur_int = ur_int;
	}
	public String getUr_string() {
		return ur_string;
	}
	public void setUr_string(String ur_string) {
		this.ur_string = ur_string;
	}
	@Override
	public String toString() {
		return "UserRole [ur_id=" + ur_id + ", u_id=" + u_id + ", r_id=" + r_id + ", ur_int=" + ur_int + ", ur_string="
				+ ur_string + "]";
	}
	
}
