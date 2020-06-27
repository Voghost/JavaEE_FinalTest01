package com.Model.Database;

import com.Model.Entity.Project;
import com.Model.Entity.Staff;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Edgar Liu
 */

public class DatabaseStaff {
	DataBean dataBean = new DataBean();
	DataSource dataSource = dataBean.getDataSource();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	// 插入数据
	public int insertStaff(Staff staff) {

		String maxStaffId = "S00001";
		String sqlSearch = "SELECT MAX(StaffId) AS maxID FROM staff";
		String sqlInsert = "INSERT INTO staff(StaffId,StaffName,StaffPhone,StaffPassword) VALUES(?,?,?,?)";

		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sqlSearch);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				maxStaffId = resultSet.getString("maxId");
				if (maxStaffId == null) {
					maxStaffId = "S00001";
				} else {
					int tmp = Integer.parseInt(maxStaffId.substring(maxStaffId.length() - 5));
					tmp++;
					maxStaffId = "S" + String.format("%05d", tmp);
				}
			}
			preparedStatement = connection.prepareStatement(sqlInsert);
			preparedStatement.setString(1, maxStaffId);
			preparedStatement.setString(2, staff.getStaffName());
			preparedStatement.setString(3, staff.getStaffPhone());
			preparedStatement.setString(4, staff.getStaffPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			closeProcess(connection, resultSet, preparedStatement);
		}
		return 1;
	}

	// 修改数据
	public int updateStaff(Staff staff) {
		try {
			connection = dataSource.getConnection();
			if (staff.getStaffName() != null) {
				preparedStatement = connection.prepareStatement("UPDATE staff SET StaffName=? WHERE StaffId=?");
				preparedStatement.setString(1, staff.getStaffName());
				preparedStatement.setString(2, staff.getStaffId());
				preparedStatement.executeUpdate();

			}
			if (staff.getStaffFileID() != null) {
				preparedStatement = connection.prepareStatement("UPDATE staff SET StaffFileId=? WHERE StaffId=?");
				preparedStatement.setString(1, staff.getStaffFileID());
				preparedStatement.setString(2, staff.getStaffId());
				preparedStatement.executeUpdate();
			}

			if (staff.getStaffPhone() != null) {
				preparedStatement = connection.prepareStatement("UPDATE staff SET StaffPhone=? WHERE StaffId=?");
				preparedStatement.setString(1, staff.getStaffPhone());
				preparedStatement.setString(2, staff.getStaffId());
				preparedStatement.executeUpdate();
			}

			if (staff.getStaffPassword() != null) {
				preparedStatement = connection.prepareStatement("UPDATE Staff SET StaffPassword=? WHERE StaffId=?");
				preparedStatement.setString(1, staff.getStaffPassword());
				preparedStatement.setString(2, staff.getStaffId());
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
			return 0;
		} finally {
			closeProcess(connection, resultSet, preparedStatement);
		}
		return 1;
	}

	// 删除数据
	public int deleteStaff(Staff staff) {
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement("delete from staff where staffId=?");
			preparedStatement.setString(1, staff.getStaffId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.toString());
			return 0;
		} finally {
			closeProcess(connection, resultSet, preparedStatement);
		}
		return 1;
	}

	// 查找数据
	public ArrayList<Staff> searchStaff(String key, int paramNo) {
		ArrayList<Staff> staffs = new ArrayList<Staff>();
		String tempElement;
		if (paramNo == 1) {
			tempElement = "StaffId";
		} else if (paramNo == 2) {
			tempElement = "StaffName";
		} else if (paramNo == 3) {
			tempElement = "StaffPhone";
		} else {
			System.out.println("ERROR 参数错误");
			return null;
		}

		try {

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement("select * from staff where " + tempElement + "=?");
			preparedStatement.setString(1, key);
			resultSet = preparedStatement.executeQuery();
			String tmp;
			int countOfResult = 0;
			while (resultSet.next()) {
				Staff newStaff = new Staff();
				if ((tmp = resultSet.getString(1)) != null) {
					newStaff.setStaffId(tmp);
				}
				if ((tmp = resultSet.getString(2)) != null) {
					newStaff.setStaffName(tmp);
				}
				if ((tmp = resultSet.getString(3)) != null) {
					newStaff.setStaffPhone(tmp);
				}
				if ((tmp = resultSet.getString(4)) != null) {
					newStaff.setStaffFileID(tmp);
				}
				if ((tmp = resultSet.getString(5)) != null) {
					newStaff.setStaffPassword(tmp);
				}
				countOfResult++;
				staffs.add(newStaff);
			}
			if (countOfResult == 0) {
				return new ArrayList<Staff>();
			}

		} catch (SQLException e) {
			System.out.println(e.toString());
			return null;
		} finally {
			closeProcess(connection, resultSet, preparedStatement);
		}
		return staffs;
	}

	//查找数据(通过对象)
	public ArrayList<Staff> searchStaff(Staff staff) {
		ArrayList<Staff> staffs = new ArrayList<Staff>();
		String sql = "SELECT * FROM  staff WHERE 1=1";
		int countOfCondition = 0; //拥有条件的次数
		String[] condition = new String[8];

		if (staff.getStaffId() != null) {
			sql = sql + " AND staffId=?";
			condition[countOfCondition] = staff.getStaffId();
			countOfCondition++;
		}
		if (staff.getStaffName() != null) {
			sql = sql + " AND StaffName=?";
			condition[countOfCondition] = staff.getStaffName();
			countOfCondition++;
		}
		if (staff.getStaffPhone() != null) {
			sql = sql + " AND StaffPhone=?";
			condition[countOfCondition] = staff.getStaffPhone();
			countOfCondition++;
		}
		if (staff.getStaffFileID() != null) {
			sql = sql + " AND StaffFileId=?";
			condition[countOfCondition] = staff.getStaffFileID();
			countOfCondition++;
		}
		if (staff.getStaffPassword() != null) {
			sql = sql + " AND StaffPassword=?";
			condition[countOfCondition] = staff.getStaffPassword();
			countOfCondition++;
		}

		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 1; i <= countOfCondition; i++) {
				preparedStatement.setString(i, condition[i - 1]);
			}
			resultSet = preparedStatement.executeQuery();
			String tmp;
			while (resultSet.next()) {
				Staff newStaff = new Staff();

				if ((tmp = resultSet.getString(1)) != null) {
					newStaff.setStaffId(tmp);
				}
				if ((tmp = resultSet.getString(2)) != null) {
					newStaff.setStaffName(tmp);
				}
				if ((tmp = resultSet.getString(3)) != null) {
					newStaff.setStaffPhone(tmp);
				}
				if ((tmp = resultSet.getString(4)) != null) {
					newStaff.setStaffFileID(tmp);
				}
				if ((tmp = resultSet.getString(5)) != null) {
					newStaff.setStaffPassword(tmp);
				}
				staffs.add(newStaff);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
			return new ArrayList<Staff>();
		} finally {
			closeProcess(connection, resultSet, preparedStatement);
		}
		return staffs;
	}

	//包装了关闭函数，用于关闭数据库相关的连接
	public int closeProcess(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement) {
		int flag = 1;
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
				flag = 0;
			}
		}
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
				flag = 0;
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		return flag;
	}
}
