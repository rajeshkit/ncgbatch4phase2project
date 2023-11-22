package com.example.air_ticket_reservation_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "login", indexes = {@Index(name = "idx_email", columnList = "email")})
public class Login {
    @Id
    private String email;
   private String password;


}
