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
     public List<AppointmentDto>getAppointments(int patientId){

        List<AppointmentDto> appointmentsDto = new ArrayList<>();
        String sql = "SELECT first_name, last_name, service_details, office_name, office_address, office.phone_number, appt_date, is_notified, is_approved FROM appointment " +
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
    public int createAppointment(Appointment appointment){
        int newAppointmentId = 0;
        int serviceId = appointment.getServiceId();
        int officeId = appointment.getOfficeId();
        int patientId = appointment.getPatientId();
        int doctorId = appointment.getDoctorId();
        String apptDate = appointment.getApptDate();
        boolean approved = appointment.getApproved();
        boolean notified = appointment.getNotified();

        String sql = "";

        try {
            newAppointmentId = jdbcTemplate.queryForObject
                    (sql, int.class, serviceId, patientId, officeId, doctorId, apptDate, approved, notified);


        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }catch(NullPointerException error){
            throw new DaoException("Unable to process user data, Null pointer exception", error);
        }
        return newAppointmentId;

    }
    private AppointmentDto mapRowToAppointmentDto(SqlRowSet rs){
        AppointmentDto appointment = new AppointmentDto();

        appointment.setDoctorFirstName(rs.getString("doctor_first_name"));
        appointment.setDoctorLastName(rs.getString("doctor_last_name"));
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
            if(rs.getString("appt_date") != null) {
                appointment.setApptDate(rs.getString("appt_date"));;
            }
//            if(rs.getString("appt_to") != null){
//                appointment.setApptTo(rs.getTime("hours_to").toLocalTime());
//            }

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
