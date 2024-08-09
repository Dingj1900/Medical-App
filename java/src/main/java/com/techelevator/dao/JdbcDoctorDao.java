package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Appointment;
import com.techelevator.model.Office;
import com.techelevator.model.User;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcDoctorDao implements DoctorDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcDoctorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Appointment> getAppointmentsByDoctor(int doctorId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM appointment " + "WHERE doctor_id = ? ";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
            while (results.next()) {
                Appointment appointment = mapRowToAppointment(results);
                appointments.add(appointment);
            }
            } catch(CannotGetJdbcConnectionException e){
                throw new DaoException("Unable to connect to server or database", e);
            }
            return appointments;
        }

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

    private Office mapRowToOffice(SqlRowSet rs) {
        Office office = new Office();
        office.setOfficeId(rs.getInt("office_id"));
        office.setOfficeName(rs.getString("office_name"));
        office.setOfficeAddress(rs.getString("office_address"));
        office.setPhoneNumber(rs.getString("phone_number"));
        try {
            if(rs.getDate("hours_from") != null) {
                office.setHoursFrom(rs.getTime("hours_from").toLocalTime());
            }
            if(rs.getDate("hours_to") != null) {
                office.setHoursTo(rs.getTime("hours_to").toLocalTime());
            }
        }catch (NullPointerException error){
            throw new DaoException("Null pointer exception for a user value", error);
        }catch(Exception error){
            throw new DaoException("general mapper error", error);
    }
        return office;
    }


    private Appointment mapRowToAppointment(SqlRowSet rs){
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(rs.getInt("appointment_id"));
        appointment.setOfficeId(rs.getInt("office_id"));
        appointment.setPatientId(rs.getInt("patient_id"));
        appointment.setDoctorId(rs.getInt("doctor_id"));
        try {
            if(rs.getDate("appt_from") != null) {
                appointment.setApptFrom(rs.getTime("appt_from").toLocalTime());;
            }
            if(rs.getDate("hours_to") != null){
                appointment.setApptTo(rs.getTime("hours_to").toLocalTime());
            }

            appointment.setMonday((boolean) rs.getObject("is_monday"));
            appointment.setTuesday((boolean) rs.getObject("is_tuesday"));
            appointment.setWednesday((boolean) rs.getObject("is_wednesday"));
            appointment.setThursday((boolean) rs.getObject("is_thursday"));
            appointment.setFriday((boolean) rs.getObject("is_friday"));
            appointment.setSaturday((boolean) rs.getObject("is_saturday"));
            appointment.setSunday((boolean) rs.getObject("is_sunday"));
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


