package com.lihao.demo.springboot.po;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // 定义一个实体，映射到数据库表中
@Table(name="clazz") // 定义对应的表名
public class Clazz {
	@Id // 定义主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自动生成id
	private Integer id;
    
	private String name;
    
	private String major;  
	
	
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@OneToMany(mappedBy="clazz")
	private List<Student> students; 
	
	public String getName() {
		return name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
}
