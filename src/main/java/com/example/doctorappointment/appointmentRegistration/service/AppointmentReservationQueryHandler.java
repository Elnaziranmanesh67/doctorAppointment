package com.example.doctorappointment.appointmentRegistration.service;

import com.example.doctorappointment.appointmentRegistration.controller.model.AppointmentRegistrationQueryModel;
import com.example.doctorappointment.appointmentRegistration.orm.Reservation;
import com.example.doctorappointment.appointmentRegistration.orm.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@Component
public class AppointmentReservationQueryHandler {


    private final ReservationRepository reservationRepository;

    @QueryHandler
    public AppointmentRegistrationQueryModel findAppointmentById(Integer id) throws Exception {
        Reservation appointment = reservationRepository.findById(id).orElseThrow(() -> new Exception("APPOINTMENT_NOT_FOUND"));

        AppointmentRegistrationQueryModel appointmentRegistrationQueryModel = new AppointmentRegistrationQueryModel();
        appointmentRegistrationQueryModel.setName(appointment.getName());
        appointmentRegistrationQueryModel.setDate(appointment.getDate());
        appointmentRegistrationQueryModel.setMobilePhone(appointment.getMobilePhone());

        return appointmentRegistrationQueryModel;

    }



}
