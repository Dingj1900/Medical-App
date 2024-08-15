package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Appointment;
import com.techelevator.model.AppointmentDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcAppointmentDao implements AppointmentDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcAppointmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     @Override
     public List<AppointmentDto> getAppointmentsByPatientId(int patientId){

        List<AppointmentDto> appointmentsDto = new ArrayList<>();
        String sql = "SELECT appointment_id, first_name, last_name, service_details, office_name, office_address, " +
                "office.phone_number, appt_date, is_notified, is_approved, services.service_id, office.office_id, patient_id, appointment.doctor_id " +
                "FROM appointment " +
                "JOIN office ON office.office_id = appointment.office_id " +
                "JOIN services ON services.service_id = appointment.service_id " +
                "JOIN users ON users.user_id = appointment.doctor_id " +
                "WHERE patient_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
            while (results.next()) {
                AppointmentDto appointment = mapRowToAppointmentDto(results);
                appointmentsDto.add(appointment);
            }
        } catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        return appointmentsDto;
    }
    @Override
    public List<AppointmentDto> getAppointmentsByDoctorId(int doctorId){

        List<AppointmentDto> appointmentsDto = new ArrayList<>();
        String sql = "SELECT appointment_id, first_name, last_name, service_details, office_name, office_address, " +
                "office.phone_number, appt_date, is_notified, is_approved, services.service_id, office.office_id, " +
                "patient_id, appointment.doctor_id, gender, email, users.phone_number, date_of_birth " +
                "FROM appointment " +
                "JOIN office ON office.office_id = appointment.office_id " +
                "JOIN services ON services.service_id = appointment.service_id " +
                "JOIN users ON users.user_id = appointment.patient_id " +
                "WHERE appointment.doctor_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
            while (results.next()) {
                AppointmentDto appointment = mapRowToAppointmentDto(results);
                appointmentsDto.add(appointment);
            }
        } catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        return appointmentsDto;
    }
    @Override
    public int deleteAppointmentById(int appointmentId) {
        int numberOfRows = 0;
        String sql = "DELETE FROM appointment WHERE appointment_id = ?;";
        try {
            numberOfRows = jdbcTemplate.update(sql, appointmentId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return numberOfRows;
    }

    public Appointment createAppointment(Appointment appointment){
        int newAppointmentId = 0;
        int serviceId = appointment.getServiceId();
        int officeId = appointment.getOfficeId();
        int patientId = appointment.getPatientId();
        int doctorId = appointment.getDoctorId();
        String apptDate = appointment.getApptDate();
        boolean approved = appointment.getApproved();
        boolean notified = appointment.getNotified();

        String sql = "INSERT INTO appointment " +
                "(service_id, office_id, patient_id, doctor_id, appt_date, " +
                "is_notified, is_approved) " +
                "values (?, ?, ?, ?, to_timestamp(?, 'YYYY-MM-DD hh24:mi:ss'), ?, ?) " +
                "RETURNING appointment_id;";

        try {
            newAppointmentId = jdbcTemplate.queryForObject
                    (sql, int.class, serviceId, officeId, patientId, doctorId, apptDate, notified, approved);


        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new DaoException("Data integrity violation", e);
        }

        appointment.setAppointmentId(newAppointmentId);

        return appointment;

    }
    private AppointmentDto mapRowToAppointmentDto(SqlRowSet rs){
        AppointmentDto appointment = new AppointmentDto();

        appointment.setAppointmentId(rs.getInt("appointment_id"));
        appointment.setDoctorFirstName(rs.getString("first_name"));
        appointment.setDoctorLastName(rs.getString("last_name"));
        appointment.setServiceDescription(rs.getString("service_details"));
        appointment.setOfficeName(rs.getString("office_name"));
        appointment.setOfficeAddress(rs.getString("office_address"));
        appointment.setOfficePhone(rs.getString("phone_number"));
        appointment.setApptDate(rs.getString("appt_date"));


        appointment.setServiceId(rs.getInt("service_id"));
        appointment.setOfficeId(rs.getInt("office_id"));
        appointment.setPatientId(rs.getInt("patient_id"));
        appointment.setDoctorId(rs.getInt("doctor_id"));


        appointment.setNotified(rs.getBoolean("is_notified"));
        appointment.setApproved(rs.getBoolean("is_approved"));

        appointment.setGender(rs.getString("gender"));
        appointment.setEmail(rs.getString("email"));
        appointment.setPhone_number(rs.getString("phone_number"));
        try{
            if(rs.getString("date_of_birth") != null){
                appointment.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
            }
        }catch(NullPointerException error){
            throw new DaoException("Null pointer, date of birth");
        }

        return appointment;
    }

//    @Override
//    public List<Appointment> getAppointmentsByDoctor(int doctorId) {
//        List<Appointment> appointments = new ArrayList<>();
//        String sql = "SELECT * " +
//                "FROM appointment " + "WHERE doctor_id = ? ";
//        try {
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
//            while (results.next()) {
//                Appointment appointment = mapRowToAppointment(results);
//                appointments.add(appointment);
//            }
//        } catch(CannotGetJdbcConnectionException e){
//            throw new DaoException("Unable to connect to server or database", e);
//        }
//        return appointments;
//    }


//    public List<Appointment> getAppointments2(int patientId){
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

    private Appointment mapRowToAppointment(SqlRowSet rs){
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(rs.getInt("appointment_id"));
        appointment.setServiceId(rs.getInt("service_id"));
        appointment.setOfficeId(rs.getInt("office_id"));
        appointment.setPatientId(rs.getInt("patient_id"));
        appointment.setDoctorId(rs.getInt("doctor_id"));
        appointment.setApptDate(rs.getString("appt_date"));

        try {
//            if(rs.getString("appt_from") != null) {
//                appointment.setApptFrom(rs.getTime("appt_from").toLocalTime());;
//            }
//            if(rs.getString("appt_to") != null){
//                appointment.setApptTo(rs.getTime("hours_to").toLocalTime());
//            }

//            appointment.setOpenMonday(rs.getBoolean("is_monday"));
//            appointment.setOpenTuesday(rs.getBoolean("is_tuesday"));
//            appointment.setOpenWednesday(rs.getBoolean("is_wednesday"));
//            appointment.setOpenThursday(rs.getBoolean("is_thursday"));
//            appointment.setOpenFriday(rs.getBoolean("is_friday"));
//            appointment.setOpenSaturday(rs.getBoolean("is_saturday"));
//            appointment.setOpenSunday(rs.getBoolean("is_sunday"));
            appointment.setNotified(rs.getBoolean("is_notified"));
            appointment.setApproved(rs.getBoolean("is_approved"));
        } catch (NullPointerException error){
            throw new DaoException("Null pointer exception for a user value", error);
        }catch(Exception error){
            throw new DaoException("general mapper error", error);
        }

        return appointment;
    }


}
