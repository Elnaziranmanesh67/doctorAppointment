package com.example.doctorappointment.appointmentRegistration.orm;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;


@Repository
public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Integer>,
        JpaSpecificationExecutor<Reservation>, JpaRepository<Reservation, Integer> {
    Reservation findByName(String name);

    Page<Reservation> findAllByName(String name, Pageable aInPageable);

}
