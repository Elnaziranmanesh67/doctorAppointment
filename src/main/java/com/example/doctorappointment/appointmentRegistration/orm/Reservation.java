package com.example.doctorappointment.appointmentRegistration.orm;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="reserve")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;
    @Column(name = "name")
    private  String name;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "date")
    private Date date;


    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", date=" + date +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(mobilePhone, that.mobilePhone) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mobilePhone, date);
    }


}
