package com.example.doctorappointment.appointmentRegistration.controller;


import com.example.doctorappointment.appointmentRegistration.controller.model.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/appointment-registration")
public class AppointmentRegistrationCommandController {


   private RestTemplate restTemplate;
   private final CommandGateway commandGateway;

   @PostMapping()
   public ResponseEntity<String> test(@RequestBody @Valid AppointmentRegistrationModel appointmentRegistrationModel) {
         commandGateway.sendAndWait(AppointmentRegistrationCommand.builder()
                 .eventId(UUID.randomUUID().toString())
                 .name(appointmentRegistrationModel.name())
                 .mobilePhone(appointmentRegistrationModel.mobilePhone())
                 .date(appointmentRegistrationModel.date())
                 .build());

return new ResponseEntity<>("your appointment is recorded", HttpStatus.CREATED);

   }

   @DeleteMapping("/{id}")
   public Boolean deleteAppointment(@PathVariable Integer id) {
      commandGateway.sendAndWait(AppointmentDeleteCommand.builder()
              .eventId(UUID.randomUUID().toString())
              .id(id)
              .build());
      return  Boolean.TRUE;
   }


   @PutMapping("/{id}")
   public Boolean updateAppointment(@RequestBody @Valid AppointmentRegistrationUpdateModel appointmentRegistrationUpdateModel, @PathVariable Integer id) {
      commandGateway.sendAndWait(AppointmentCommandUpdate.builder()
              .eventId(UUID.randomUUID().toString())
              .name(appointmentRegistrationUpdateModel.name())
              .id(id)
              .date(appointmentRegistrationUpdateModel.date())
              .mobilePhone(appointmentRegistrationUpdateModel.mobilePhone())
              .build());
      return  Boolean.TRUE;
   }

}