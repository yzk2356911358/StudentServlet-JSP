package com.yzk.student.dao;

import java.util.List;

import com.yzk.student.model.Classs;

public interface ClasssDao {

	int insert(Classs classs);

	int delete(int id);

	int update(Classs classs);

	List<Classs> selectByName(String name);

	Classs selectById(int id);

	List<Classs> selectAll();
}