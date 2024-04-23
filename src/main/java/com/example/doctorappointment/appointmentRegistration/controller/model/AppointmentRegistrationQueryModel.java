package com.example.doctorappointment.appointmentRegistration.controller.model;

import lombok.Data;

import java.util.Date;

@Data
public class AppointmentRegistrationQueryModel {
   private String name;
   private String mobilePhone;
   private Date date;
}

