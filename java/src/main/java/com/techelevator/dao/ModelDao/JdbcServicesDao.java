package com.techelevator.dao.ModelDao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Appointment;
import com.techelevator.model.Services;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcServicesDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcServicesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Services getServiceByDoctor(int doctorId) {
        Services service = null;

        String sql = "SELECT * " +
                "FROM services " +
                "WHERE doctor_id = ? ";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
            if (results.next()) {
                service = mapRowToServices(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return service;
    }

    public List<Services> getServicesByDoctor(int doctorId){
        List<Services> services = new ArrayList<>();

        String sql = "SELECT * " +
                "FROM services " + "WHERE doctor_id = ? ";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
            while (results.next()) {
                Services service = mapRowToServices(results);
                services.add(service);
            }
        } catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        return services;
    }

    public Services updateServiceById(Services services){

        Services updatedServices = null;
        String sql = "UPDATE services SET service_name = ?, service_details = ?, hourly_rate = ?, " +
                "doctor_id = ? " +
                "WHERE service_id = ?";

        try {
            int numberOfRows = jdbcTemplate.update(sql, services.getServiceName(), services.getServiceDetails(),
                    services.getHourlyRate(), services.getDoctorId(), services.getServiceId());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedServices = getServiceByDoctor(services.getServiceId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedServices;
    }

    public int createService(Services services, int doctorId){
        int newServiceId = 0;

        String serviceName = services.getServiceName();
        String serviceDetails = services.getServiceDetails();
        Double hourlyRate = services.getHourlyRate();
        int doctorId = services.getDoctorId();


        String sql = "INSERT INTO services " +
                "(service_name, service_details, hourly_rate, doctor_id) " +
                "values (LOWER(TRIM(?)), ?, ?, ?, ?) RETURNING service_id";

        try {
            newServiceId = jdbcTemplate.queryForObject
                    (sql, int.class, serviceName, serviceDetails, hourlyRate, doctorId);

            getServiceByDoctor(newServiceId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }catch(NullPointerException error){
            throw new DaoException("Unable to process user data, Null pointer exception", error);
        }
        return newServiceId;

    }

    private Services mapRowToServices(SqlRowSet rs){
        Services services = new Services();
        services.setServiceId(rs.getInt("service_id"));
        services.setServiceName(rs.getString("service_name"));
        services.setServiceDetails(rs.getString("service_details"));
        services.setHourlyRate(rs.getDouble("hourly_rate"));
        services.setDoctorId(rs.getInt("doctor_id"));

        return services;
    }
}
