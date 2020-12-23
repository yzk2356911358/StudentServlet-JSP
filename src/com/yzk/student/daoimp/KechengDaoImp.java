package com.yzk.student.daoimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yzk.student.dao.KechengDao;
import com.yzk.student.model.Kecheng;

public class KechengDaoImp implements KechengDao {
	private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/StudentSystem-JSP-Servlet?serverTimezone=UTC";
	private final String userName = "root";
	private final String password = "root";

	@Override
	public int insert(Kecheng temp) {
		int n = 0;
		String sql = "insert into Kecheng values (default,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(url, userName, password);
			ps = conn.prepareStatement(sql);
			ps.setString(1, temp.getName());
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
		String sql = "delete from Kecheng where id=?";
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
	public int update(Kecheng kecheng) {
		String sql = "update Kecheng set name=? where id=?";
		int n = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(url, userName, password);
			ps = conn.prepareStatement(sql);
			ps.setString(1, kecheng.getName());
			ps.setInt(2, kecheng.getId());
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
	public List<Kecheng> selectByName(String name) {
		return null;
	}

	@Override
	public Kecheng selectById(int id) {
		for (Kecheng classs : selectAll()) {
			if (classs.getId() == id) {
				return classs;
			}
		}
		return null;
	}

	@Override
	public List<Kecheng> selectAll() {
		String sql = "select * from Kecheng";
		List<Kecheng> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(url, userName, password);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Kecheng classs = new Kecheng(rs.getInt("id"), rs.getString("name"));
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
