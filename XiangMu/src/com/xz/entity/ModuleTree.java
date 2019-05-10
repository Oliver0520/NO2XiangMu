package com.xz.entity;

import java.util.List;

public class ModuleTree {
	private Integer id;
	private String text;
	private Boolean checked;
	private List<ModuleTree> children;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public List<ModuleTree> getChildren() {
		return children;
	}
	public void setChildren(List<ModuleTree> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "ModuleTree [id=" + id + ", text=" + text + ", checked=" + checked + ", children=" + children + "]";
	}
	
}
