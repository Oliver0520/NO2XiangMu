package com.xz.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class User {
	private Integer	u_id;
	private String	u_loginName;
	private String	u_userName;
	private Integer	u_isLockout;
	private String	u_lastLoginTime;
	private String	u_createTime;
	private String	u_password;
	private String	u_email;
	private String	u_phoneNumber;
	private String	u_qdshijian;
	private String	u_qdstatus;
	private Integer	u_weight;
	private String	u_weightbeizhu;
	private Integer	u_int;
	private String	u_string;
	
	private String paixu;
	public String getPaixu() {
		return paixu;
	}
	public void setPaixu(String paixu) {
		this.paixu = paixu;
	}
	private String stime;
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	private String etime;
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getU_loginName() {
		return u_loginName;
	}
	public void setU_loginName(String u_loginName) {
		this.u_loginName = u_loginName;
	}
	public String getU_userName() {
		return u_userName;
	}
	public void setU_userName(String u_userName) {
		this.u_userName = u_userName;
	}
	public Integer getU_isLockout() {
		return u_isLockout;
	}
	public void setU_isLockout(Integer u_isLockout) {
		this.u_isLockout = u_isLockout;
	}
	public String getU_lastLoginTime() {
		return u_lastLoginTime;
	}
	public void setU_lastLoginTime(String u_lastLoginTime) {
		this.u_lastLoginTime = u_lastLoginTime;
	}
	public String getU_createTime() {
		return u_createTime;
	}
	public void setU_createTime(String u_createTime) {
		this.u_createTime = u_createTime;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	
	public String getU_qdshijian() {
		return u_qdshijian;
	}
	public void setU_qdshijian(String u_qdshijian) {
		this.u_qdshijian = u_qdshijian;
	}
	
	public String getU_qdstatus() {
		return u_qdstatus;
	}
	public void setU_qdstatus(String u_qdstatus) {
		this.u_qdstatus = u_qdstatus;
	}
	public Integer getU_weight() {
		return u_weight;
	}
	public void setU_weight(Integer u_weight) {
		this.u_weight = u_weight;
	}
	public String getU_weightbeizhu() {
		return u_weightbeizhu;
	}
	public void setU_weightbeizhu(String u_weightbeizhu) {
		this.u_weightbeizhu = u_weightbeizhu;
	}
	public Integer getU_int() {
		return u_int;
	}
	public void setU_int(Integer u_int) {
		this.u_int = u_int;
	}
	public String getU_string() {
		return u_string;
	}
	public void setU_string(String u_string) {
		this.u_string = u_string;
	}
	public String getU_phoneNumber() {
		return u_phoneNumber;
	}
	public void setU_phoneNumber(String u_phoneNumber) {
		this.u_phoneNumber = u_phoneNumber;
	}
	
	
	private List<Role> role;
	public List<Role> getRole() {
		return role;
	}
	public void setRole(List<Role> role) {
		this.role = role;
	}
	private String opwd;
	private String npwd;
	private String apwd;
	public String getOpwd() {
		return opwd;
	}
	public void setOpwd(String opwd) {
		this.opwd = opwd;
	}
	public String getNpwd() {
		return npwd;
	}
	public void setNpwd(String npwd) {
		this.npwd = npwd;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_loginName=" + u_loginName + ", u_userName=" + u_userName + ", u_isLockout="
				+ u_isLockout + ", u_lastLoginTime=" + u_lastLoginTime + ", u_createTime=" + u_createTime
				+ ", u_password=" + u_password + ", u_email=" + u_email + ", u_phoneNumber=" + u_phoneNumber
				+ ", u_qdshijian=" + u_qdshijian + ", u_qdstatus=" + u_qdstatus + ", u_weight=" + u_weight
				+ ", u_weightbeizhu=" + u_weightbeizhu + ", u_int=" + u_int + ", u_string=" + u_string + ", paixu="
				+ paixu + ", stime=" + stime + ", etime=" + etime + ", role=" + role + ", opwd=" + opwd + ", npwd="
				+ npwd + ", apwd=" + apwd + "]";
	}
}
