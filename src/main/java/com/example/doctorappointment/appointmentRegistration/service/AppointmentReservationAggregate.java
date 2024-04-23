package com.example.doctorappointment.appointmentRegistration.service;

import com.example.doctorappointment.appointmentRegistration.controller.model.*;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.Date;


@Aggregate
@NoArgsConstructor
public class AppointmentReservationAggregate {
    @AggregateIdentifier
    private String eventId;
    private Integer id;
    private String name;
    private String mobilePhone;
    private Date date;

    private Integer version;

    @CommandHandler
    public AppointmentReservationAggregate(AppointmentRegistrationCommand appointmentRegistrationCommand) {

        AppointmentReservationCreateEvent reservationCreateEvent = new AppointmentReservationCreateEvent();
        BeanUtils.copyProperties(appointmentRegistrationCommand, reservationCreateEvent);
        AggregateLifecycle.apply(reservationCreateEvent);
    }

    @CommandHandler
    public AppointmentReservationAggregate(AppointmentDeleteCommand appointmentDeleteCommand){
        AppointmentDeleteEvent appointmentDeleteEvent=new AppointmentDeleteEvent();
        BeanUtils.copyProperties(appointmentDeleteCommand, appointmentDeleteEvent);
        AggregateLifecycle.apply(appointmentDeleteEvent);
    }


    @CommandHandler
    public AppointmentReservationAggregate(AppointmentCommandUpdate appointmentCommandUpdate){
        AppointmentEventUpdate appointmentEventUpdate=new AppointmentEventUpdate();
        BeanUtils.copyProperties(appointmentCommandUpdate,appointmentEventUpdate);
        AggregateLifecycle.apply(appointmentEventUpdate);
    }


    @EventSourcingHandler
    public void create(AppointmentReservationCreateEvent reservationCreateEvent) {
        this.eventId = reservationCreateEvent.getEventId();
        this.name = reservationCreateEvent.getName();
        this.mobilePhone = reservationCreateEvent.getMobilePhone();
        this.date=reservationCreateEvent.getDate();
        this.version=reservationCreateEvent.getVersion();
    }

    @EventSourcingHandler
    public void delete (AppointmentDeleteEvent appointmentDeleteEvent) {
        this.eventId = appointmentDeleteEvent.getEventId();
        this.id=appointmentDeleteEvent.getId();

    }


    @EventSourcingHandler
    public void update (AppointmentEventUpdate userEventUpdate) {
        this.eventId = userEventUpdate.getEventId();
        this.id=userEventUpdate.getId();
        this.name = userEventUpdate.getName();
        this.mobilePhone = userEventUpdate.getMobilePhone();
        this.date = userEventUpdate.getDate();
    }


}
