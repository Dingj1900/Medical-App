package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcPatientDao implements PatientDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPatientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
@Override
    public User getDoctorByOfficeId(int officeId){
       User doctor = null;

       String sql = "SELECT * " +
               "FROM users " +
               "JOIN doctor_office ON user_id = doctor_office.doctor_id " +
               "WHERE office_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
            if (results.next()) {
                doctor = mapRowToDoctor(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return doctor;

    }

//@Override

//@Override
//    public List<Appointment> getAppointments(int patientId){
//        List<Appointment> appointments = new ArrayList<>();
//
//        String sql = "SELECT * " +
//                "FROM appointment " + "WHERE patient_id = ? ";
//        try {
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
//            while (results.next()) {
//                Appointment appointment = mapRowToAppointment(results);
//                appointments.add(appointment);
//            }
//        } catch(CannotGetJdbcConnectionException e){
//            throw new DaoException("Unable to connect to server or database", e);
//        }
//        return appointments;
//    }
//    @Override
//    public int createAppointment(Appointment appointment){
//        int newAppointmentId = 0;
//
//        int serviceId = appointment.getServiceId();
//        int officeId = appointment.getOfficeId();
//        int patientId = appointment.getPatientId();
//        int doctorId = appointment.getDoctorId();
//        LocalTime apptFrom = appointment.getApptFrom();
//        LocalTime apptTo = appointment.getApptTo();
//        boolean openMonday = appointment.isOpenMonday();
//        boolean openTuesday = appointment.isOpenTuesday();
//        boolean openWednesday = appointment.isOpenWednesday();
//        boolean openThursday = appointment.isOpenThursday();
//        boolean openFriday = appointment.isOpenFriday();
//        boolean openSaturday = appointment.isOpenSaturday();
//        boolean openSunday = appointment.isOpenSunday();
//        boolean notified = appointment.isNotified();
//        boolean approved = appointment.isApproved();
//
//        String sql = "INSERT INTO appointment " +
//                "(service_id, office_id, patient_id, doctor_id, appt_from, appt_to, is_Monday, " +
//                "is_Tuesday, is_Wednesday, is_Thursday, is_Friday, is_Saturday, is_Sunday, " +
//                "is_notified, is_approved) " +
//                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
//                "RETURNING appointment_id";
//
//        try {
//            newAppointmentId = jdbcTemplate.queryForObject
//                    (sql, int.class, serviceId, officeId, patientId, doctorId, apptFrom, apptTo, openMonday, openTuesday, openWednesday, openThursday,
//                            openFriday, openSaturday, openSunday, notified, approved);
//
//           // getAppointments(newAppointmentId);
//
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        } catch (DataIntegrityViolationException e) {
//            throw new DaoException("Data integrity violation", e);
//        }catch(NullPointerException error){
//            throw new DaoException("Unable to process user data, Null pointer exception", error);
//        }
//        return newAppointmentId;
//
//    }
 @Override
    public List<Office> getOffices(){
        List<Office> offices = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM office";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Office office = mapRowToOffice(results);
                offices.add(office);
            }
        } catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        return offices;
    }
//    @Override
//    public List<Services> getServicesByDoctor(int doctorId){
//        List<Services> services = new ArrayList<>();
//
//        String sql = "SELECT * " +
//                "FROM services " + "WHERE doctor_id = ? ";
//
//        try {
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
//            while (results.next()) {
//                Services service = mapRowToServices(results);
//                services.add(service);
//            }
//        } catch(CannotGetJdbcConnectionException e){
//            throw new DaoException("Unable to connect to server or database", e);
//        }
//        return services;
//    }

    @Override
    public List<Services> getServices(){
        List<Services> services = new ArrayList<>();

        String sql = "SELECT * " +
                "FROM services " +
                "GROUP BY service_name ";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
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
    public List<ServiceDto> getServiceInfoByName(String serviceName){
        List<ServiceDto> serviceDtoList = new ArrayList<>();

        String sql = "Select * from services " +
                "Join users ON users.user_id = services.doctor_id " +
                "Join doctor_office ON users.user_id = doctor_office.doctor_id " +
                "Join office ON doctor_office.office_id = office.office_id " +
                "where service_name = ? ";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, serviceName);

            while(results.next()){
                Office office = mapRowToOffice(results);
                User doctor = mapRowToDoctor(results);
                Services service =mapRowToServices(results);

                ServiceDto serviceDto = new ServiceDto();
                serviceDto.setOffice(office);
                serviceDto.setUser(doctor);
                serviceDto.setService(service);

                serviceDtoList.add(serviceDto);
            }

        }catch(CannotGetJdbcConnectionException error){
            throw new DaoException("Unable to connect to server or database", error);
        }

        return serviceDtoList;
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

    private Services mapRowToServices(SqlRowSet rs){
        Services services = new Services();
        services.setServiceId(rs.getInt("service_id"));
        services.setServiceName(rs.getString("service_name"));
        services.setServiceDetails(rs.getString("service_details"));
        services.setHourlyRate(rs.getDouble("hourly_rate"));
        services.setDoctorId(rs.getInt("doctor_id"));

        return services;
    }



    public User mapRowToDoctor(SqlRowSet rs) {
        User user = new User();
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setMiddleInitials(rs.getString("middle_initials"));
        user.setGender(rs.getString("gender"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setEmail(rs.getString("email"));

        try {
            //will produce null pointers if date or time is null
            if (rs.getDate("date_of_birth") != null) {
                user.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
            }
            if (rs.getString("hours_from") != null) {
                user.setHoursFrom(LocalTime.parse(rs.getString("hours_from")));
            }
            if (rs.getString("hours_to") != null) {
                user.setHoursTo(LocalTime.parse(rs.getString("hours_to")));
            }

            user.setOpenMonday(rs.getBoolean("is_monday"));
            user.setOpenTuesday(rs.getBoolean("is_tuesday"));
            user.setOpenWednesday(rs.getBoolean("is_wednesday"));
            user.setOpenThursday(rs.getBoolean("is_thursday"));
            user.setOpenFriday(rs.getBoolean("is_friday"));
            user.setOpenSaturday(rs.getBoolean("is_saturday"));
            user.setOpenSunday(rs.getBoolean("is_sunday"));

        } catch (NullPointerException error) {
            throw new DaoException("Null pointer exception for a user value", error);
        } catch (Exception error) {
            throw new DaoException("general mapper error", error);
        }
        return user;
    }

}
