package com.xz.entity;

import org.springframework.stereotype.Component;

@Component
public class RoleModule {
	private Integer rm_id;
	private Integer r_id;
	private Integer m_id;
	private Integer rm_int;
	private String rm_string;
	public Integer getRm_id() {
		return rm_id;
	}
	public void setRm_id(Integer rm_id) {
		this.rm_id = rm_id;
	}
	public Integer getR_id() {
		return r_id;
	}
	public void setR_id(Integer r_id) {
		this.r_id = r_id;
	}
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public Integer getRm_int() {
		return rm_int;
	}
	public void setRm_int(Integer rm_int) {
		this.rm_int = rm_int;
	}
	public String getRm_string() {
		return rm_string;
	}
	public void setRm_string(String rm_string) {
		this.rm_string = rm_string;
	}
	@Override
	public String toString() {
		return "RoleModule [rm_id=" + rm_id + ", r_id=" + r_id + ", m_id=" + m_id + ", rm_int=" + rm_int
				+ ", rm_string=" + rm_string + "]";
	}
	
}
