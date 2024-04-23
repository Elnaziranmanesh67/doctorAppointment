package com.example.doctorappointment.appointmentRegistration.controller;

import com.example.doctorappointment.appointmentRegistration.controller.model.AppointmentRegistrationQueryModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/appointment-registration")
public class AppointmentRegistrationQueryController {

    private final QueryGateway queryGateway;

    @GetMapping({"/{id}"})
    public AppointmentRegistrationQueryModel findAppointmentById(@PathVariable() Integer id) throws Exception {
        return queryGateway.query(id, AppointmentRegistrationQueryModel.class).join();
    }


}