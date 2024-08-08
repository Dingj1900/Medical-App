package com.techelevator.dao;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.techelevator.exception.DaoException;
import com.techelevator.model.RegisterUserDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.techelevator.model.User;

@Component
public class JdbcUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUserById(int userId) {
        User user = null;
        String sql = "SELECT user_id, username, password_hash, role FROM users WHERE user_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            if (results.next()) {
                user = mapRowToUser(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id, username, password_hash, role FROM users";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                User user = mapRowToUser(results);
                users.add(user);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return users;
    }

    @Override
    public User getUserByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");
        User user = null;
        String sql = "SELECT user_id, username, password_hash, role FROM users WHERE username = LOWER(TRIM(?));";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, username);
            if (rowSet.next()) {
                user = mapRowToUser(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return user;
    }

    @Override
    public User createUser(RegisterUserDto user) {
        User newUser = null;

        String password_hash = new BCryptPasswordEncoder().encode(user.getPassword());
        String ssRole = user.getRole().toUpperCase().startsWith("ROLE_") ? user.getRole().toUpperCase() : "ROLE_" + user.getRole().toUpperCase();

        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String middleInitials = user.getMiddleInitials(); //optional
        String gender = user.getGender();
        String phoneNumber = user.getPhoneNumber();
        String email = user.getEmail();
        Date dateOfBirth = user.getDateOfBirth();

        //properties of doctor
        LocalTime hoursFrom = null;
        LocalTime hoursTo = null;
        boolean isMonday = false;
        boolean isTuesday = false;
        boolean isWednesday = false;
        boolean isThursday = false;
        boolean isFriday = false;
        boolean isSaturday = false;
        boolean isSunday = false;

        //properties of patient
        String address = "";
        String city = "";
        String stateAbbreviation = "";
        String zipcode = "";

        if(user.getRole().equals("provider")) {
            //only doctor
            hoursFrom = user.getHoursFrom();
            hoursTo = user.getHoursTo();
            isMonday = user.isMonday();
            isTuesday = user.isTuesday();
            isWednesday = user.isWednesday();
            isThursday = user.isThursday();
            isFriday = user.isFriday();
            isSaturday = user.isSaturday();
            isSunday = user.isSunday();
        }
        else {
            //everyone else is a patient
            address = user.getAddress();
            city = user.getCity();
            stateAbbreviation = user.getStateAbbreviation();
            zipcode = user.getZipcode();

        }

        String insertUserSql = "INSERT INTO users " +
                "(" +
                "username, " +
                "password_hash, " +
                "role, " +
                "first_name, " +
                "last_name, " +
                "middle_initials, " +
                "gender, " +
                "phone_number, " +
                "email, " +
                "date_of_birth," +
                "address, " +
                "city, " +
                "state_abbreviation, " +
                "zip_code, " +
                "hours_from, " +
                "hours_to, " +
                "is_monday, " +
                "is_tuesday, " +
                "is_wednesday, " +
                "is_thursday, " +
                "is_friday, " +
                "is_saturday, " +
                "is_sunday, " +
                ") values (LOWER(TRIM(?)), ?, ?, ?) RETURNING user_id";



        try {
            int newUserId = jdbcTemplate.queryForObject(insertUserSql, int.class,
                    user.getUsername(),
                    password_hash,
                    ssRole,
                    firstName,
                    lastName,
                    middleInitials,
                    gender,
                    phoneNumber,
                    email,
                    dateOfBirth,
                    address,
                    city,
                    stateAbbreviation,
                    zipcode,
                    hoursFrom,
                    hoursTo,
                    isMonday,
                    isTuesday,
                    isWednesday,
                    isThursday,
                    isFriday,
                    isSaturday,
                    isSunday
                    );
            newUser = getUserById(newUserId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newUser;
    }



    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password_hash"));
        user.setAuthorities(Objects.requireNonNull(rs.getString("role")));
        user.setActivated(true);
        return user;
    }

}
