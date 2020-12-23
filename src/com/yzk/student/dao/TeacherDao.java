package com.yzk.student.dao;

import java.util.List;

import com.yzk.student.model.Teacher;

public interface TeacherDao {

	int insertTeacher(Teacher teacher);

	int deleteTeacher(int id);

	int updateTeacher(Teacher teacher);

	List<Teacher> selectTeacherByName(String name);

	Teacher selectTeacherById(int id);

	List<Teacher> selectAllTeacher();
	void delkecheng(int id);
}