package com.example.doctorappointment.appointmentRegistration.controller.model;



import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Builder
public record AppointmentRegistrationModel(@Length(max = 10) String name, @NotNull String mobilePhone, Date date) {

}