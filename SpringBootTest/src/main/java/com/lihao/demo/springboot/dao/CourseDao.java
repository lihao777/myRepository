package com.lihao.demo.springboot.dao;


import org.springframework.data.repository.PagingAndSortingRepository;
import com.lihao.demo.springboot.po.Course;



public interface CourseDao extends PagingAndSortingRepository<Course, Integer> {

	

}
