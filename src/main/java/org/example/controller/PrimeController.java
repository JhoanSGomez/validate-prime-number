package org.example.controller;

import org.example.dto.ResponseDto;
import org.example.service.PrimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrimeController implements Prime {
    private final PrimeService primeService;

    public PrimeController(PrimeService primeService) {
        this.primeService = primeService;
    }

    @Override
    public ResponseEntity<ResponseDto> validatePrime(String number) {
        ResponseDto response = primeService.isPrime(number);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
