package com.lihao.demo.springboot.dao;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.lihao.demo.springboot.po.Clazz;




public interface ClazzDao extends PagingAndSortingRepository<Clazz, Integer> {

	

}
