package com.xz.entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Fenye<T> {
private Integer page;
private Integer pageSize;
private Integer total;
private T t;
private List<T> rows;
public Integer getPage() {
	return page;
}
public void setPage(Integer page) {
	this.page = page;
}
public Integer getPageSize() {
	return pageSize;
}
public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
}
public Integer getTotal() {
	return total;
}
public void setTotal(Integer total) {
	this.total = total;
}
public T getT() {
	return t;
}
public void setT(T t) {
	this.t = t;
}
public List<T> getRows() {
	return rows;
}
public void setRows(List<T> rows) {
	this.rows = rows;
}
@Override
public String toString() {
	return "Fenye [page=" + page + ", pageSize=" + pageSize + ", total=" + total + ", t=" + t + ", rows=" + rows + "]";
}

}
