package com.techelevator.dao;

import com.techelevator.model.UserRole;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface UserRoleDao {

    public UserRole createUserRole(UserRole userRole);

    public UserRole mapToRowSet(SqlRowSet results);

}
