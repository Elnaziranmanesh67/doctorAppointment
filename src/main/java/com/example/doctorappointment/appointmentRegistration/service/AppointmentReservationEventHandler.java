package com.example.doctorappointment.appointmentRegistration.service;


import com.example.doctorappointment.appointmentRegistration.controller.model.AppointmentDeleteEvent;
import com.example.doctorappointment.appointmentRegistration.controller.model.AppointmentEventUpdate;
import com.example.doctorappointment.appointmentRegistration.controller.model.AppointmentReservationCreateEvent;
import com.example.doctorappointment.appointmentRegistration.orm.Reservation;
import com.example.doctorappointment.appointmentRegistration.orm.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Component
public class AppointmentReservationEventHandler {

    private final ReservationRepository reservationRepository;

    @EventHandler
    @Transactional(rollbackFor = Exception.class)
    public void create(AppointmentReservationCreateEvent appointmentReservationCreateEvent) throws Exception {

  Reservation appointmentReservation = reservationRepository.findByName(appointmentReservationCreateEvent.getName());
        if (appointmentReservation != null) {
            throw new Exception("YOUR_APPOINTMENT_REJISTRED_BEFORE");
        } else {

            Reservation newAppointment= new Reservation();
            BeanUtils.copyProperties(appointmentReservationCreateEvent, newAppointment);
            reservationRepository.save(newAppointment);


//            TestMongo testMongo=new TestMongo();
//            testMongo.setUsername(user.getUsername());
//            testMongo.setNationalCode(user.getNationalCode());
//            testMongoRepository.save(testMongo);
        }
    }

    @EventHandler
    @Transactional(rollbackFor = Exception.class)
    public void delete(AppointmentDeleteEvent appointmentDeleteEvent) throws Exception {
        Reservation appointment = reservationRepository.findById(appointmentDeleteEvent.getId()).orElseThrow(()-> new Exception("APPOINTMENT_NOT_FOUND"));
        reservationRepository.delete(appointment);
    }

    @EventHandler
    @Transactional(rollbackFor = Exception.class)
    public void update(AppointmentEventUpdate appointmentEventUpdate) throws Exception {

        Reservation appointment = reservationRepository.findById(appointmentEventUpdate.getId()).orElseThrow(()-> new Exception("USER_NOT_FOUND"));
        BeanUtils.copyProperties(appointmentEventUpdate, appointment);
        reservationRepository.save(appointment);


    }





}
