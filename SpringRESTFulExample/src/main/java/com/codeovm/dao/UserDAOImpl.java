package com.codeovm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.codeovm.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<User> listAllUser() {
		List<User> list = new ArrayList<User>();

		String sql = "SELECT id, firstname, lastname, address FROM users";

		list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());
		return list;
	}

	private SqlParameterSource getSqlParameterByModel(User user) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if(user != null) {
			paramSource.addValue("id", user.getId());
			paramSource.addValue("firstname", user.getFirstname());
			paramSource.addValue("lastname", user.getLastname());
			paramSource.addValue("address", user.getAddress());
		}

		return paramSource;
	}

	private static final class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();

			return user;
		}

	}

	public void addUser(User user) {
		String sql = "INSERT INTO users (firstname, lastname, address) VALUES (:firstname, :lastname, :address)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
	}

	public void updateUser(User user) {
		String sql = "UPDATE users SET firstname = :firstnanme, lastname = :lastname, address = :address WHERE id = :id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
	}

	public void delete(User user) {
		String sql = "DELETE FROM users WHERE id = :id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
	}

	public User findUserById(User user) {
		String sql = "SELECT * FROM users WHERE id = :id";
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(user), new UserMapper());
	}

}
