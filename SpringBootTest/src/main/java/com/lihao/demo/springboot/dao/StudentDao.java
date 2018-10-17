package com.lihao.demo.springboot.dao;


import org.springframework.data.repository.PagingAndSortingRepository;
import com.lihao.demo.springboot.po.Student;


public interface StudentDao extends PagingAndSortingRepository<Student, Integer> {


	
}
