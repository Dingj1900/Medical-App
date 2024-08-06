package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.UserRole;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.zip.DataFormatException;

@Component
public class JdbcUserRoleDao implements UserRoleDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRoleDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public UserRole createUserRole(UserRole userRole){
        UserRole newUserRole = null;

        String findUserRole = "SELECT user_id , role_id " +
                "FROM userRole " +
                "WHERE user_id = ? AND role_id = ? ";

        String insertUserRole = "INSERT INTO userRole (user_id, role_id) " +
                "values (?,?)";

        try{
            SqlRowSet result = jdbcTemplate.queryForRowSet(findUserRole, userRole.getUserId(), userRole.getRoleId());
            if(!result.next()){
                jdbcTemplate.update(insertUserRole, userRole.getUserId(), userRole.getRoleId());

                SqlRowSet confirmation = jdbcTemplate.queryForRowSet(findUserRole, userRole.getUserId(), userRole.getRoleId());

                if(confirmation.next()){
                    newUserRole = mapToRowSet(confirmation);
                }
            }

        }catch(CannotGetJdbcConnectionException error){
            throw new DaoException("Unable to connect to server or database", error);
        }catch(DataIntegrityViolationException error){
            throw new DaoException("Data integrity violation", error);
        }
        return newUserRole;
    }

    public boolean hasRole(String roleName, int user_id){
        String sql = "SELECT COUNT(*) " +
                "FROM userRole " +
                "WHERE ";
    }

    @Override
    public UserRole mapToRowSet(SqlRowSet results){
        UserRole userRole = new UserRole();
        userRole.setRoleId(results.getInt("role_id"));
        userRole.setUserId(results.getInt("user_id"));

        return userRole;
    }


}
