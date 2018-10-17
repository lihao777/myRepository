package com.lihao.demo.springboot.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.lihao.demo.springboot.dao.ClazzDao;
import com.lihao.demo.springboot.dao.CourseDao;
import com.lihao.demo.springboot.dao.StudentDao;
import com.lihao.demo.springboot.po.Clazz;
import com.lihao.demo.springboot.po.Course;
import com.lihao.demo.springboot.po.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStudent {

	 @Resource
	 private StudentDao studentDao;
	 @Resource
	 private CourseDao courseDao;
	 @Resource
	 private ClazzDao  clazzDao;
	  @Test
	  @Transactional//启动事务
	  @Rollback(false)//数据库数据不回滚
	  public void test() {
		  Student s=new Student();
		  s.setGender("男");
		  s.setName("李浩");
		  s.setStudyNO("201510422210");
		  studentDao.save(s);
	  }
	  @Test
	  @Transactional//启动事务
	  @Rollback(false)//数据库数据不回滚
	  public void test1() {
		  Course c=new Course();
		  c.setHours(80);
		  c.setMajor("物联网");
		  c.setNo(1);
		  c.setScore(6);
		  courseDao.save(c);
	  }
	  @Test
	  @Transactional//启动事务
	  @Rollback(false)//数据库数据不回滚
	  public void test2() {
		  //从数据库查询一个课程，并创建一个集合
		  Course c=courseDao.findById(1).get();
		  List<Course> cs=new ArrayList<Course>();
		  cs.add(c);
		  //从数据库中查询一个学生，并设置关联的课程集合
		  Student s=studentDao.findById(1).get();
		  s.setCourses(cs);
		  studentDao.save(s);
	  }
	  @Test
	  @Transactional//启动事务
	  @Rollback(false)//数据库数据不回滚
	  public void  test3() {
		  List<Course> cs=new ArrayList<Course>();
		  Course c=new Course(2,"Math",80,5,"算法与设计");
	      cs.add(c);
	      courseDao.save(c);
	      Course c1=new Course(2,"The Internet of things",80,5,"物联网工程");
	      cs.add(c1);
	      courseDao.save(c1);
	      //构造学生并设置和课程的关系数据
	      Student s=new Student("001", "张子枫", "男");
	      s.setCourses(cs);
	      studentDao.save(s);
	  }
	  @Test
	  @Transactional//启动事务
	  @Rollback(false)//数据库数据不回滚
	  public void  test4() {
 	  
         Clazz c=new Clazz();
         c.setMajor("物联网");
         c.setName("2班");
         clazzDao.save(c);
         //将id为1的学生和班级关联
         Student s1=studentDao.findById(1).get();
         s1.setClazz(c);
         studentDao.save(s1);
         
         Student s2=studentDao.findById(2).get();
         s2.setClazz(c);
         studentDao.save(s2);
	  }
	  @Test
	  @Transactional//启动事务
	  @Rollback(false)//数据库数据不回滚
	  public void test6() {
		  Clazz c=clazzDao.findById(1).get();
		  System.out.println(c.getStudents());
	  }
		
}
