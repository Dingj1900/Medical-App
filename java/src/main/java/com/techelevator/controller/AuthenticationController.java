package com.techelevator.controller;

import javax.validation.Valid;

import com.techelevator.dao.DoctorDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.techelevator.dao.UserDao;
import com.techelevator.security.jwt.JWTFilter;
import com.techelevator.security.jwt.TokenProvider;
import org.w3c.dom.ls.LSOutput;

import java.security.Principal;

@RestController
@CrossOrigin
public class AuthenticationController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private UserDao userDao;
    private DoctorDao doctorDao;

    public AuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UserDao userDao, DoctorDao doctorDao) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDao = userDao;
        this.doctorDao = doctorDao;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginDto loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, false);

        User user;
        try {
            user = userDao.getUserByUsername(loginDto.getUsername());
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password is incorrect.");
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(new LoginResponseDto(jwt, user), httpHeaders, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public User register(@Valid @RequestBody RegisterUserDto newUser) {
        User user = new User();


        try {
            if (userDao.getUserByUsername(newUser.getUsername()) != null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists.");
            } else {
                 user = userDao.createUser(newUser);
                 if (newUser.getOfficeName() != null) {
                     Office office = new Office();
                     office.setHoursFrom(user.getHoursFrom());
                     office.setHoursTo(user.getHoursTo());
                     office.setOfficeName(newUser.getOfficeName());
                     office.setDoctorId(user.getId());
                     office.setOfficeAddress(newUser.getOfficeAddress());
                     office.setPhoneNumber(newUser.getOfficePhone());

                     this.doctorDao.createDoctorOffice(office, user.getId());
                 }
            }
        }
        catch (DaoException e) {
            System.out.println(e.getStackTrace());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User registration failed.");
        }

        return user;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/user/update")
    public User updateUser(@RequestBody User user, Principal principal){
        User updatedUser = new User();

        int userId = userDao.getUserByUsername(principal.getName()).getId();

        try{
            updatedUser = userDao.updateUser(user, userId);

        }catch(DaoException error){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User cannot be updated");
        }


        return updatedUser;
    }

}

