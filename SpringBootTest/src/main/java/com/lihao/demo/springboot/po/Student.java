package com.lihao.demo.springboot.po;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // 定义一个实体，映射到数据库表中
@Table(name="student") // 定义对应的表名
public class Student {
	@Id // 定义主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自动生成id
	private Integer id;
	
	@Column (name= "studentNO", length = 20) // 指定表的字段名、长度等属性
    private String studyNO;
	
	@Column (name= "name", length = 20) // 指定表的字段名、长度等属性
    private String name;
    
	private String gender;
    
	private Date birthday;
	
	@ManyToMany
	@JoinTable(name="student_course",joinColumns=@JoinColumn(name="student_id"),
	inverseJoinColumns=@JoinColumn(name="course_id"))
	private List<Course> courses;
	
	@ManyToOne
	@JoinColumn(name="clazz_id")
	private Clazz clazz;
	
	
	public List<Course> getCourses() {
		return courses;
	}
	public Student() {
		
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studyNO=" + studyNO + ", name=" + name + ", gender=" + gender + "]";
	}
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	public Student(String studyNO, String name, String gender) {
		super();
		this.studyNO = studyNO;
		this.name = name;
		this.gender = gender;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudyNO() {
		return studyNO;
	}
	public void setStudyNO(String studyNO) {
		this.studyNO = studyNO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
    
}
