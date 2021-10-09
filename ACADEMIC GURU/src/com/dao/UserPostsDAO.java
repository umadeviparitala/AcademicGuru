package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.dto.UserPosts;

public class UserPostsDAO {

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
				//userPosts.setId(resultSet.getInt(4));
				//System.out.println(resultSet.getString(1));
				postsList.add(userPosts);
				//System.out.println(userPosts.toString());
				//System.out.println("Null values");
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

	public List<UserPosts> getWorkshopPosts() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		connection = DbConnection.getConnection();
		String SELECT = "select * from questions where category='workshops';";
		
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			List<UserPosts> postsList = new ArrayList<UserPosts>();
			
			while(resultSet.next()) {
				UserPosts userPosts = new UserPosts();
				
				userPosts.setUserName(resultSet.getString(1));
				userPosts.setQuery(resultSet.getString(2));
				userPosts.setCategory(resultSet.getString(3));
				//userPosts.setId(resultSet.getInt(4));
				//System.out.println(resultSet.getString(1));
				postsList.add(userPosts);
				//System.out.println(userPosts.toString());
				//System.out.println("Null values");
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

	public List<UserPosts> getRecruitmentPosts() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		connection = DbConnection.getConnection();
		String SELECT = "select * from questions where category='recruitment';";
		
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			List<UserPosts> postsList = new ArrayList<UserPosts>();
			
			while(resultSet.next()) {
				UserPosts userPosts = new UserPosts();
				
				userPosts.setUserName(resultSet.getString(1));
				userPosts.setQuery(resultSet.getString(2));
				userPosts.setCategory(resultSet.getString(3));
				//userPosts.setId(resultSet.getInt(4));
				//System.out.println(resultSet.getString(1));
				postsList.add(userPosts);
				//System.out.println(userPosts.toString());
				//System.out.println("Null values");
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

	public List<UserPosts> getTrainingProgramsPosts() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		connection = DbConnection.getConnection();
		String SELECT = "select * from questions where category='trainingPrograms';";
		
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			List<UserPosts> postsList = new ArrayList<UserPosts>();
			
			while(resultSet.next()) {
				UserPosts userPosts = new UserPosts();
				
				userPosts.setUserName(resultSet.getString(1));
				userPosts.setQuery(resultSet.getString(2));
				userPosts.setCategory(resultSet.getString(3));
				//userPosts.setId(resultSet.getInt(4));
				//System.out.println(resultSet.getString(1));
				postsList.add(userPosts);
				//System.out.println(userPosts.toString());
				//System.out.println("Null values");
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

	public List<UserPosts> getSubjectPosts() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		connection = DbConnection.getConnection();
		String SELECT = "select * from questions where category='subjects';";
		
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			List<UserPosts> postsList = new ArrayList<UserPosts>();
			
			while(resultSet.next()) {
				UserPosts userPosts = new UserPosts();
				
				userPosts.setUserName(resultSet.getString(1));
				userPosts.setQuery(resultSet.getString(2));
				userPosts.setCategory(resultSet.getString(3));
				//userPosts.setId(resultSet.getInt(4));
				//System.out.println(resultSet.getString(1));
				postsList.add(userPosts);
				//System.out.println(userPosts.toString());
			//	System.out.println("Null values");
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

	public int insertAnswer(String userName, String category, String query, String answer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		connection = DbConnection.getConnection();
		String INSERTANSWER = "insert into answers values(?, ?, ?, ?);";
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(INSERTANSWER);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, category);
			preparedStatement.setString(3, query);
			preparedStatement.setString(4, answer);

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


}
