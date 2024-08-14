package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Appointment;
import com.techelevator.model.Office;
import com.techelevator.model.Services;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcDoctorDao implements DoctorDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcDoctorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
//@Override
//    public Appointment getAppointmentByDoctor(int doctorId) {
//        Appointment appointment = null;
//
//        String sql = "SELECT * " +
//                "FROM appointment " +
//                "WHERE doctor_id = ? ";
//
//        try {
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
//            if (results.next()) {
//                appointment = mapRowToAppointment(results);
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        }
//        return appointment;
//    }
    @Override
    public Office getOfficeByDoctor(int doctorId) {
        Office office = null;
        String sql = "SELECT * " +
                "FROM office " +
                "JOIN doctor_office USING(office_id) " +
                "WHERE doctor_id = ? ";
       try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
            if (results.next()) {
                office = mapRowToOffice(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return office;
    }
    @Override
    public int createDoctorOffice(Office office, int doctorId){
        int newOfficeId = 0;

        String officeName = office.getOfficeName();
        String officeAddress = office.getOfficeAddress();
        String phoneNumber = office.getPhoneNumber();
        LocalTime hoursFrom = office.getHoursFrom();
        LocalTime hoursTo = office.getHoursTo();


        String sql = "INSERT INTO office " +
                "(office_name, office_address, phone_number, hours_from, hours_to) " +
                "values (TRIM(?), ?, ?, ?, ?) RETURNING office_id";

        String sql2 = "INSERT INTO doctor_office " +
                "(doctor_id, office_id) " +
                "values ( ?, ?) RETURNING office_id";

        try {
            newOfficeId = jdbcTemplate.queryForObject
                    (sql, int.class, officeName, officeAddress, phoneNumber, hoursFrom, hoursTo);

            getOfficeByDoctor(newOfficeId);

            int newDocOfficeId = jdbcTemplate.queryForObject(sql2, int.class, doctorId , newOfficeId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }catch(NullPointerException error){
            throw new DaoException("Unable to process user data, Null pointer exception", error);
        }
        return newOfficeId;
    }
    @Override
    public Office updateOfficeById(Office office){

        Office updatedOffice = null;
        String sql = "UPDATE office SET office_name = ?, office_address = ?, phone_number = ?, " +
                "hours_from = ?, hours_to = ? " +
                "WHERE office_id = ?";

        try {
            int numberOfRows = jdbcTemplate.update(sql, office.getOfficeName(), office.getOfficeAddress(),
                    office.getPhoneNumber(), office.getHoursFrom(), office.getHoursTo(), office.getOfficeId());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedOffice = getOfficeByDoctor(office.getOfficeId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedOffice;
    }

    private Services getServiceByService(int serviceId) {
        Services service = null;

        String sql = "SELECT * " +
                "FROM services " +
                "WHERE service_id = ? ";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, serviceId);
            if (results.next()) {
                service = mapRowToServices(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return service;
    }
    @Override
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
    @Override
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
                updatedServices = getServiceByService(services.getServiceId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedServices;
    }
    @Override
    public int createService(Services services, int doctorId){
        int newServiceId = 0;

        String serviceName = services.getServiceName();
        String serviceDetails = services.getServiceDetails();
        Double hourlyRate = services.getHourlyRate();

        String sql = "INSERT INTO services " +
                "(service_name, service_details, hourly_rate, doctor_id) " +
                "values ((TRIM(?)), ?, ?, ?) RETURNING service_id";

        try {
            newServiceId = jdbcTemplate.queryForObject
                    (sql, int.class, serviceName, serviceDetails, hourlyRate, doctorId);

            getServiceByService(newServiceId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }catch(NullPointerException error){
            throw new DaoException("Unable to process user data, Null pointer exception", error);
        }
        return newServiceId;

    }

    private Office mapRowToOffice(SqlRowSet rs) {
        Office office = new Office();
        office.setOfficeId(rs.getInt("office_id"));
        office.setOfficeName(rs.getString("office_name"));
        office.setOfficeAddress(rs.getString("office_address"));
        office.setPhoneNumber(rs.getString("phone_number"));
        try {
            if(rs.getString("hours_from") != null) {
                office.setHoursFrom(rs.getTime("hours_from").toLocalTime());
            }
            if(rs.getString("hours_to") != null) {
                office.setHoursTo(rs.getTime("hours_to").toLocalTime());
            }
        }catch (NullPointerException error){
            throw new DaoException("Null pointer exception for a user value", error);
        }catch(Exception error){
            throw new DaoException("general mapper error", error);
    }
        return office;
    }


//    private Appointment mapRowToAppointment(SqlRowSet rs){
//        Appointment appointment = new Appointment();
//        appointment.setAppointmentId(rs.getInt("appointment_id"));
//        appointment.setServiceId(rs.getInt("service_id"));
//        appointment.setOfficeId(rs.getInt("office_id"));
//        appointment.setPatientId(rs.getInt("patient_id"));
//        appointment.setDoctorId(rs.getInt("doctor_id"));
//        try {
//            if(rs.getString("appt_from") != null) {
//                appointment.setApptFrom(rs.getTime("appt_from").toLocalTime());;
//            }
//            if(rs.getString("appt_to") != null){
//                appointment.setApptTo(rs.getTime("hours_to").toLocalTime());
//            }
//
//            appointment.setOpenMonday((boolean) rs.getObject("is_monday"));
//            appointment.setOpenTuesday((boolean) rs.getObject("is_tuesday"));
//            appointment.setOpenWednesday((boolean) rs.getObject("is_wednesday"));
//            appointment.setOpenThursday((boolean) rs.getObject("is_thursday"));
//            appointment.setOpenFriday((boolean) rs.getObject("is_friday"));
//            appointment.setOpenSaturday((boolean) rs.getObject("is_saturday"));
//            appointment.setOpenSunday((boolean) rs.getObject("is_sunday"));
//            appointment.setNotified((boolean)rs.getObject("is_notified"));
//            appointment.setApproved((boolean)rs.getObject("is_approved"));
//        } catch (NullPointerException error){
//            throw new DaoException("Null pointer exception for a user value", error);
//        }catch(Exception error){
//            throw new DaoException("general mapper error", error);
//        }
//
//        return appointment;
//    }

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


