package com.xz.entity;

import org.springframework.stereotype.Component;

@Component
public class Module {
	private Integer m_id;
	private String m_name;
	private Integer m_parentId;
	private String m_path;
	private Integer m_weight;
	private Integer m_int;
	private String checked;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public Integer getM_parentId() {
		return m_parentId;
	}
	public void setM_parentId(Integer m_parentId) {
		this.m_parentId = m_parentId;
	}
	public String getM_path() {
		return m_path;
	}
	public void setM_path(String m_path) {
		this.m_path = m_path;
	}
	public Integer getM_weight() {
		return m_weight;
	}
	public void setM_weight(Integer m_weight) {
		this.m_weight = m_weight;
	}
	public Integer getM_int() {
		return m_int;
	}
	public void setM_int(Integer m_int) {
		this.m_int = m_int;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	@Override
	public String toString() {
		return "Module [m_id=" + m_id + ", m_name=" + m_name + ", m_parentId=" + m_parentId + ", m_path=" + m_path
				+ ", m_weight=" + m_weight + ", m_int=" + m_int + ", checked=" + checked + "]";
	}
	
}
