package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.rowset.JdbcRowSet;

@Component
public class JbbcRoleDao implements RoleDao {


    private final JdbcTemplate jdbcTemplate;

    public JbbcRoleDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getRoleIdByName(String roleName){

        int roleId = 0;

        String sql = "SELECT role_id " +
                "FROM role " +
                "WHERE role = ? ";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, roleName );

            if(results.next()){
                roleId = results.getInt("role_id");
            }

        } catch(CannotGetJdbcConnectionException error){
            throw new DaoException("Unable to connect to server or database", error);

        }catch(DataIntegrityViolationException error){
            throw new DaoException("Data Integrity Violation", error);
        }

        return roleId;
    }



}
