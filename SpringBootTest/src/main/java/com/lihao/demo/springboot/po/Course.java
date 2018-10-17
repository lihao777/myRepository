package com.lihao.demo.springboot.po;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity // 定义一个实体，映射到数据库表中
@Table(name="course") // 定义对应的表名
public class Course {
  
  @Id // 定义主键-代理主键
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 自动生成id
  private  Integer id;
  
  private Integer no;//课程号-自然主键
  
  private String name;
  
  private Integer hours;
  
  private Integer score;
  
  private String major;
  
  @ManyToMany(mappedBy="courses")//mappedBy表示放弃对关系数据的维护，值是关联对象的属性
  private List<Student> students;

public List<Student> getStudents() {
	return students;
}
public Course() {
	
}
public Course(Integer no, String name, Integer hours, Integer score, String major) {
	super();
	this.no = no;
	this.name = name;
	this.hours = hours;
	this.score = score;
	this.major = major;
}

public void setStudents(List<Student> students) {
	this.students = students;
}


public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Integer getNo() {
	return no;
}

public void setNo(Integer no) {
	this.no = no;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Integer getHours() {
	return hours;
}

public void setHours(Integer hours) {
	this.hours = hours;
}

public Integer getScore() {
	return score;
}

public void setScore(Integer score) {
	this.score = score;
}

public String getMajor() {
	return major;
}

public void setMajor(String major) {
	this.major = major;
}
  

}
