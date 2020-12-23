//package com.yzk.student.util;
//
//import java.util.ArrayList;
//
//import com.yzk.student.model.Student;
//
//public class JdbcMysql {
//
//	public static void main(String[] args) {
//
//		Student student = new Student(2, "小明", "男", 18, "Java", "Java");
//		String sql3 = " INSERT INTO Student (name, gender, age,classs,major)VALUES('1121', '菜鸟教程',12,'菜鸟教程','菜鸟教程');";
//		String sql = "DELETE FROM Student WHERE id=" + 2 + ";";
//		
//		String sql1 = "select * from Student";
//		String sql2 = "select * from Student where id = ?";
////		System.out.println(JdbcUtil.queryForArray(sql1)[1][1]);
////		System.out.println(JdbcUtil.queryForList(sql1));
////		System.out.println(JdbcUtil.queryForMap(sql2, 1));
//		JdbcUtil.UpdateStudent(student);
//	}
//}