package com.yzk.student.daoimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yzk.student.dao.ClasssDao;
import com.yzk.student.model.Classs;

public class ClasssDaoImp implements ClasssDao {
	private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/StudentSystem-JSP-Servlet?serverTimezone=UTC";
	private final String userName = "root";
	private final String password = "root";

	@Override
	public int insert(Classs classs) {
		int n = 0;
		String sql = "insert into Classs values (default,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(url, userName, password);
			ps = conn.prepareStatement(sql);
			ps.setString(1, classs.getName());
			n = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // �ر����ݿ���Դ
			try {
				if (null != ps) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (null != conn) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n;
	}

	@Override
	public int delete(int id) {
		String sql = "delete from Classs where id=?";
		int n = 0;
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(url, userName, password);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			n = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != ps) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (null != conn) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return n;
	}

	@Override
	public int update(Classs classs) {
		String sql = "update Classs set name=? where id=?";
		int n = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(url, userName, password);
			ps = conn.prepareStatement(sql);
			ps.setString(1, classs.getName());
			ps.setInt(2, classs.getId());
			n = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != ps) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (null != conn) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n;
	}

	@Override
	public List<Classs> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Classs selectById(int id) {
		for (Classs classs : selectAll()) {
			if (classs.getId() == id) {
				return classs;
			}
		}
		return null;
	}

	@Override
	public List<Classs> selectAll() {
		String sql = "select * from Classs";
		List<Classs> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(url, userName, password);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Classs classs = new Classs(rs.getInt("id"), rs.getString("name"));
				list.add(classs);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != ps) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (null != conn) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

}
