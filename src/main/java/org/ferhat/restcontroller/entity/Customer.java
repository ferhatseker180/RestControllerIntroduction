package org.ferhat.restcontroller.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "customer_name", nullable = false, length = 50)
    private String name;

    @Email(message = "Invalid mail address")
    @Column(name = "customer_mail", unique = true)
    private String mail;

    @Temporal(TemporalType.DATE)
    @Column(name = "customer_on_date")
    private LocalDate onDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_gender", nullable = false)
    private Gender gender;

    public enum Gender {
        MALE,
        FEMALE
    }


}
