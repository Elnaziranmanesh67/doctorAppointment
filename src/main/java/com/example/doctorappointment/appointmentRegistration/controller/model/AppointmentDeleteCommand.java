package com.example.doctorappointment.appointmentRegistration.controller.model;

import lombok.*;
import org.axonframework.modelling.command.AggregateIdentifier;

@Data
@Builder
public class AppointmentDeleteCommand
{
    private  Integer id;

    @AggregateIdentifier
    private String eventId;
}
