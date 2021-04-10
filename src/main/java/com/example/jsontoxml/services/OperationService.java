package com.example.jsontoxml.services;

import com.example.jsontoxml.dto.Request;
import com.example.jsontoxml.exception.InvalidRequestException;
import com.example.jsontoxml.model.Operation;
import com.example.jsontoxml.repository.OperationRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.example.jsontoxml.configs.Constants.*;

@Service
public class OperationService {
    private final OperationRepository operationRepository;

    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public String getXml(Request request){
        try {
            if (request.getId() == null)
                throw new InvalidRequestException(exception_xml);
            if (request.getSupplier_id() == null)
                throw new InvalidRequestException(exception_xml);
            if (request.getAccount() == null)
                throw new InvalidRequestException(exception_xml);
            if (request.getAmount() == null)
                throw new InvalidRequestException(exception_xml);
            if (request.getCommand() == null)
                throw new InvalidRequestException(exception_xml);
            if (request.getDate() == null)
                throw new InvalidRequestException(exception_xml);

            if (request.getCommand().equals("check")){
                saveOperation(request);
                int pId = Integer.parseInt(request.getAccount().substring(6));
                return String.format(correcr_xml_check,request.getId(),request.getDate(),pId);
            }
            else if (request.getCommand().equals("pay")){
                saveOperation(request);
                int pId = Integer.parseInt(request.getAccount().substring(6));
                return String.format(correcr_xml_pay,request.getId(),request.getDate(),pId);
            }
            else
                throw new InvalidRequestException(exception_xml_command);
        }
        catch (NullPointerException | ParseException | DateTimeParseException e) {
            return e.getMessage();
        }

    }


    public void saveOperation(Request request) throws ParseException {
        String pattern = ("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        operationRepository.save(Operation.builder()
                .id(request.getId())
                .supplierId(request.getSupplier_id())
                .account(request.getAccount())
                .amount(request.getAmount())
                .command(request.getCommand())
                .date(LocalDateTime.parse(request.getDate(),formatter))
                .build()
        );
    }

}
