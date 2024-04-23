package com.example.doctorappointment.appointmentRegistration.controller.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Builder
public record AppointmentRegistrationCommand(@Length(max = 10) String name, @NotNull String mobilePhone, Date date,@AggregateIdentifier String eventId) {
}
