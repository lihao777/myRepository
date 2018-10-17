package com.lihao.demo.springboot.test;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.lihao.demo.springboot.dao.UserDao;
import com.lihao.demo.springboot.po.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUser {
	 @Resource
     private UserDao userDao;
	  @Test
	  @Transactional//启动事务
	  @Rollback(false)//数据库数据不回滚
	  public void test() { 
		  for(int i=0;i<10;i++) { 
		  User u=new User();
		  u.setLoginName("lihao"+i);
		  userDao.save(u);
		  }
	  }
	  @Test
	  @Transactional//启动事务
	  @Rollback(false)//数据库数据不回滚
	  public void demo(){
		  User u=userDao.findById(1).get();
		  System.out.println(u.getLoginName());
		  u.setLoginName("lihao");
		  userDao.save(u);
		  userDao.delete(u);
	  }
	  @Test
	  @Transactional//启动事务
	  @Rollback(false)//数据库数据不回滚
	  public void test2() {
		  //分页条件
		  Pageable p=PageRequest.of(1, 10, Direction.DESC, "id");
		  Page<User> users=userDao.findAllByLoginNameLike("%lihao%",p);
		  List<User> userPage2=users.getContent();
		  System.out.println(userPage2);
		  System.out.println("total:"+users.getTotalElements());
	  }

	  
}
