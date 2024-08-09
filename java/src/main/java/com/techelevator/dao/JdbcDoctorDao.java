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
        office.setOfficeId(rs.getInt("office_id"));
        office.setOfficeName(rs.getString("office_name"));
        office.setOfficeAddress(rs.getString("office_address"));
        office.setPhoneNumber(rs.getString("phone_number"));
        try {
            if(rs.getDate("hours_from") != null) {
                office.setHoursFrom(rs.getTime("hours_from").toLocalTime());
            }
            if(rs.getDate("hours_to") != null) {
                office.setHoursTo(rs.getTime("hours_to").toLocalTime());
            }
        }
    }


}
