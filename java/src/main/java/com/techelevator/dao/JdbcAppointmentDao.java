package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Appointment;
import com.techelevator.model.AppointmentDto;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcAppointmentDao implements AppointmentDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcAppointmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
     public List<AppointmentDto>getAppointments(int patientId){

        List<AppointmentDto> appointmentsDto = new ArrayList<>();
        String sql = "SELECT first_name, last_name, service_details, office_name, office_address, office.phone_number, appt_from, appt_to, is_notified, is_approved FROM appointment " +
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
    private AppointmentDto mapRowToAppointmentDto(SqlRowSet rs){
        AppointmentDto appointment = new AppointmentDto();

        appointment.setDoctorName(rs.getString("doctor_name"));
        appointment.setServiceDescription(rs.getString("service_description"));
        appointment.setOfficeName(rs.getString("office_name"));
        appointment.setOfficeAddress(rs.getString("office_address"));
        appointment.setOfficePhone(rs.getString("office_phone"));
        appointment.setAppointmentId(rs.getInt("appointment_id"));
        appointment.setServiceId(rs.getInt("service_id"));
        appointment.setOfficeId(rs.getInt("office_id"));
        appointment.setPatientId(rs.getInt("patient_id"));
        appointment.setDoctorId(rs.getInt("doctor_id"));
        try {
            if(rs.getString("appt_from") != null) {
                appointment.setApptFrom(rs.getTime("appt_from").toLocalTime());;
            }
            if(rs.getString("appt_to") != null){
                appointment.setApptTo(rs.getTime("hours_to").toLocalTime());
            }

            appointment.setOpenMonday((boolean) rs.getObject("is_monday"));
            appointment.setOpenTuesday((boolean) rs.getObject("is_tuesday"));
            appointment.setOpenWednesday((boolean) rs.getObject("is_wednesday"));
            appointment.setOpenThursday((boolean) rs.getObject("is_thursday"));
            appointment.setOpenFriday((boolean) rs.getObject("is_friday"));
            appointment.setOpenSaturday((boolean) rs.getObject("is_saturday"));
            appointment.setOpenSunday((boolean) rs.getObject("is_sunday"));
            appointment.setNotified((boolean)rs.getObject("is_notified"));
            appointment.setApproved((boolean)rs.getObject("is_approved"));
        } catch (NullPointerException error){
            throw new DaoException("Null pointer exception for a user value", error);
        }catch(Exception error){
            throw new DaoException("general mapper error", error);
        }

        return appointment;
    }

}
