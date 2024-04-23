package com.example.doctorappointment.appointmentRegistration.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentReservationCreateEvent {
    @AggregateIdentifier
    private String eventId;
    private Integer version;
    private Integer id;
    private String name;
    private Date date;
    private String mobilePhone;

}