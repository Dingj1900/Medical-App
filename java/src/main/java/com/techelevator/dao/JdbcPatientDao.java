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
public class JdbcPatientDao implements PatientDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPatientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Office getDoctorByOfficeId(int officeId){
       Office office = null;

       String sql = "SELECT * " +
               "FROM office " +
               "JOIN doctor_office USING(office_id) " +
               "WHERE doctor_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
            if (results.next()) {
                office = mapRowToOffice(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return office;

    }

    public List<Appointment> getAppointments(int patientId){
        List<Appointment> appointments = new ArrayList<>();

        String sql = "SELECT * " +
                "FROM appointment " + "WHERE patient_id = ? ";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
            while (results.next()) {
                Appointment appointment = mapRowToAppointment(results);
                appointments.add(appointment);
            }
        } catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        return appointments;
    }

    public int createAppointment(Appointment appointment, int patientId){
        int newAppointmentId = 0;

        int serviceId = appointment.getServiceId();
        int officeId = appointment.getOfficeId();
        patientId = appointment.getPatientId();
        int doctorId = appointment.getDoctorId();
        LocalTime apptFrom = appointment.getApptFrom();
        LocalTime apptTo = appointment.getApptTo();
        boolean isMonday = appointment.isMonday();
        boolean isTuesday = appointment.isTuesday();
        boolean isWednesday = appointment.isWednesday();
        boolean isThursday = appointment.isThursday();
        boolean isFriday = appointment.isFriday();
        boolean isSaturday = appointment.isSaturday();
        boolean isSunday = appointment.isSunday();
        boolean isNotified = appointment.isNotified();
        boolean isApproved = appointment.isApproved();

        String sql = "INSERT INTO appointment " +
                "(service_id, office_id, patient_id, doctor_id, appt_from, appt_to, is_Monday, " +
                "is_Tuesday, is_Wednesday, is_Thursday, is_Friday, is_Saturday, is_Sunday, " +
                "is_notified, is_approved) " +
                "values ((TRIM(?)), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING appointment_id";

        try {
            newAppointmentId = jdbcTemplate.queryForObject
                    (sql, int.class, serviceId, officeId, patientId, doctorId, apptFrom, apptTo, isMonday, isTuesday, isWednesday, isThursday,
                            isFriday, isSaturday, isSunday, isNotified, isApproved);

            getAppointments(newAppointmentId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }catch(NullPointerException error){
            throw new DaoException("Unable to process user data, Null pointer exception", error);
        }
        return newAppointmentId;

    }

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

    private Appointment mapRowToAppointment(SqlRowSet rs){
        Appointment appointment = new Appointment();
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
