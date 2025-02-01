package org.example.controller;

import org.example.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

public interface Prime {

    @RequestMapping(value = "/api/validate-prime/{number}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<ResponseDto> validatePrime(@PathVariable("number") String number) throws IOException;
}
