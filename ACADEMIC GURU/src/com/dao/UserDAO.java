package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.dto.User;
import com.dto.UserPosts;

public class UserDAO {

	public User getUser(String loginId, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String SELECT = "select * from user where userName = ? and password = ?;";
		connection = DbConnection.getConnection();

		try {
			preparedStatement = connection.prepareStatement(SELECT);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				User user = new User();

				user.setFirstName(resultSet.getString(1));
				user.setLastName(resultSet.getString(2));
				user.setUserName(resultSet.getString(3));
				user.setMailId(resultSet.getString(4));
				user.setPassword(resultSet.getString(5));
				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection != null) {

					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int register(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		connection = DbConnection.getConnection();
		String INSERT = "insert into user values(?, ?, ?, ?, ?);";
		int result = 0;

		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setString(4, user.getMailId());
			preparedStatement.setString(5, user.getPassword());

			result = preparedStatement.executeUpdate();
			return result;



		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection != null) {
					preparedStatement.close();
					connection.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

	public int insertQuery(String userName, String query, String category) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		connection = DbConnection.getConnection();
		/*PreparedStatement pst1 = connection.prepareStatement("select max(id)+1 from questions");
        ResultSet rs = pst1.executeQuery();
        String user_id ="" ;
        while(rs.next())
        {
            user_id = rs.getString(1);
        }*/
		String INSERTQUERY = "insert into questions values(?, ?, ?);";
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(INSERTQUERY);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, query);
			preparedStatement.setString(3, category);

			//result = preparedStatement.getGeneratedKeys();
			result = preparedStatement.executeUpdate();
			return result;



		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection != null) {
					preparedStatement.close();
					connection.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int update(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		connection = DbConnection.getConnection();
		String UPDATE = "update user set firstName=?, lastName=?, userName=?, mailId=?, password=? where userName=?;";

		try {
			preparedStatement = connection.prepareStatement(UPDATE);
			
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setString(4, user.getMailId());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setString(6, user.getUserName());

			int result = preparedStatement.executeUpdate();
			return result;



		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection != null) {
					preparedStatement.close();
					connection.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

	public List<UserPosts> getPosts() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		connection = DbConnection.getConnection();
		String SELECT = "select * from questions;";
		
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			List<UserPosts> postsList = new ArrayList<UserPosts>();
			
			while(resultSet.next()) {
				UserPosts userPosts = new UserPosts();
				
				userPosts.setUserName(resultSet.getString(1));
				userPosts.setQuery(resultSet.getString(2));
				userPosts.setCategory(resultSet.getString(3));
				//System.out.println(resultSet.getString(1));
				postsList.add(userPosts);
				System.out.println(userPosts.toString());
				System.out.println("Null values");
			}
			return postsList;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(connection != null) {
					preparedStatement.close();
					resultSet.close();
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


}
