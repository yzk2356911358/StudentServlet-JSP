package com.yzk.student.daoimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yzk.student.dao.ChengjiDao;
import com.yzk.student.model.Chengji;

public class ChengjiDaoImp implements ChengjiDao {
	private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/StudentSystem-JSP-Servlet?serverTimezone=UTC";
	private final String userName = "root";
	private final String password = "root";

	@Override
	public int insert(Chengji temp) {
		int n = 0;
		String sql = "insert into Chengji values (default,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(url, userName, password);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, temp.getSid());
			ps.setString(2, temp.getKname());
			ps.setString(3, temp.getFenshu());
			ps.setString(4, temp.getTeacher());
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
		String sql = "delete from chengji where id=?";
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
	public int update(Chengji kecheng) {
		String sql = "update chengji set fenshu=? where id=?";
		int n = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(url, userName, password);
			ps = conn.prepareStatement(sql);
			ps.setString(1, kecheng.getFenshu());
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
	public List<Chengji> selectByName(String name) {
		return null;
	}

	@Override
	public Chengji selectById(int id) {
		for (Chengji classs : selectAll()) {
			if (classs.getId() == id) {
				return classs;
			}
		}
		return null;
	}

	@Override
	public List<Chengji> selectAll() {
		String sql = "select * from Chengji";
		List<Chengji> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(url, userName, password);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Chengji classs = new Chengji(rs.getInt("id"), rs.getInt("sid"), rs.getString("kname"),
						rs.getString("fenshu"),rs.getString("teacher"));
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
