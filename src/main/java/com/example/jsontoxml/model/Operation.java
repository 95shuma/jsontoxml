package com.example.jsontoxml.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "account")
    private String account;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "command")
    private String command;

    @Column(name = "date")
    private LocalDateTime date;


}
