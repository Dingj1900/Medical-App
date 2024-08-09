package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Office;
import com.techelevator.model.User;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcDoctorDao implements DoctorDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcDoctorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Office getOfficeByDoctor(int doctorId) {
        Office office = null;
        String sql = "SELECT * FROM office WHERE user_id = ?";
//        try {
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
//            if (results.next()) {
//                user = mapRowToUser(results);
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        }
//        return user;
//    }
    }

    private Office mapRowToOffice(SqlRowSet rs) {
        Office office = new Office();

    }


}
