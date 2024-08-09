package com.techelevator.dao.ModelDao;

import com.techelevator.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcPatientDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Patient getPatientById(int user_id){
        Patient newPatient = null;

        String sql = "SELECT * " +
                "FROM user " +
                "WHERE user_id = ? ";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user_id);

            if(results.next()){

            }

        }catch(DataIntegrityViolationException error){
            throw new DaoException("Data Integrity Violation", error);
        }catch(CannotGetJdbcConnectionException error){
            throw new DaoException("Unable to access to server or database", error);
        }

        return newPatient;
    }



}
