package com.example.doctorappointment.appointmentRegistration.controller.model;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public record AppointmentRegistrationUpdateModel(@Length(max = 10) String name, @NotNull String mobilePhone, Date date) {
}
