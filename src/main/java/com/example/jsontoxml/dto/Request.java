package com.example.jsontoxml.dto;

import lombok.Data;

@Data
public class Request {

    private Long id;
    private Long supplier_id;
    private String account;
    private Double amount;
    private String command;
    private String date;

}
