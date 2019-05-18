package com.xz.entity;

import org.springframework.stereotype.Component;

@Component
public class IsFenpei {
private Integer id;
private Integer fenpei;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getFenpei() {
	return fenpei;
}
public void setFenpei(Integer fenpei) {
	this.fenpei = fenpei;
}
@Override
public String toString() {
	return "IsFenpei [id=" + id + ", fenpei=" + fenpei + "]";
}

}
