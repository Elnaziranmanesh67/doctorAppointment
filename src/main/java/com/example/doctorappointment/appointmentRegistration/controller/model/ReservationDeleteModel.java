package com.example.doctorappointment.appointmentRegistration.controller.model;

import lombok.Builder;

@Builder
public record ReservationDeleteModel(Integer id, String eventId) {
}
