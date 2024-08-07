package com.techelevator.dao.ModelDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcPatientDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    

}
