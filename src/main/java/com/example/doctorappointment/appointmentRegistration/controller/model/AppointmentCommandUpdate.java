package com.example.doctorappointment.appointmentRegistration.controller.model;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;


@Builder
@Data
public class AppointmentCommandUpdate {

    @TargetAggregateIdentifier
    private final String eventId;
    private final Integer id;
    private final String name;
    private final String mobilePhone;
    private final Date date;
}
