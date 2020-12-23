package com.yzk.student.dao;

import java.util.List;

import com.yzk.student.model.Kecheng;

public interface KechengDao {

	int insert(Kecheng temp);

	int delete(int id);

	int update(Kecheng temp);

	List<Kecheng> selectByName(String name);

	Kecheng selectById(int id);

	List<Kecheng> selectAll();
}