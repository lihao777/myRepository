package com.lihao.demo.springboot.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // 定义一个实体，映射到数据库表中
@Table(name="user") // 定义对应的表名
public class User {
	@Id // 定义主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自动生成id
    private Integer id;
	
	@Column (name= "login_name", length = 20) // 指定表的字段名、长度等属性
    private String loginName;
	
	private String password="123";
	
    private Date createDate;
    
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", password=" + password + ", createDate=" + createDate
				+ "]";
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
    
}
