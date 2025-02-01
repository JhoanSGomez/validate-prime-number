package org.example.controller;

import org.example.dto.ResponseDto;
import org.example.service.PrimeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PrimeControllerTest {

    @Mock
    private PrimeService primeService;

    private PrimeController primeController;

    @BeforeEach
    void setUp() {
        primeController = new PrimeController(primeService);
    }

    @Test
    void validatePrime_WhenNumberIsPrime_ShouldReturnSuccessResponse() {
        String primeNumber = "17";
        ResponseDto expectedResponse = new ResponseDto("El número 17 es primo");
        when(primeService.isPrime(primeNumber)).thenReturn(expectedResponse);

        ResponseEntity<ResponseDto> response = primeController.validatePrime(primeNumber);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        assertEquals("El número 17 es primo", response.getBody().getMessage());
        verify(primeService).isPrime(primeNumber);
    }

    @Test
    void validatePrime_WhenNumberIsNotPrime_ShouldReturnSuccessResponse() {
        String nonPrimeNumber = "4";
        ResponseDto expectedResponse = new ResponseDto("El número 4 no es primo");
        when(primeService.isPrime(nonPrimeNumber)).thenReturn(expectedResponse);

        ResponseEntity<ResponseDto> response = primeController.validatePrime(nonPrimeNumber);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        assertEquals("El número 4 no es primo", response.getBody().getMessage());
        verify(primeService).isPrime(nonPrimeNumber);
    }

    @Test
    void validatePrime_WhenInputIsInvalid_ShouldReturnSuccessResponse() {
        String invalidInput = "abc";
        ResponseDto expectedResponse = new ResponseDto("Entrada inválida: debe ser un número");
        when(primeService.isPrime(invalidInput)).thenReturn(expectedResponse);

        ResponseEntity<ResponseDto> response = primeController.validatePrime(invalidInput);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        assertEquals("Entrada inválida: debe ser un número", response.getBody().getMessage());
        verify(primeService).isPrime(invalidInput);
    }

    @Test
    void validatePrime_WhenInputIsEmpty_ShouldReturnSuccessResponse() {
        String emptyInput = "";
        ResponseDto expectedResponse = new ResponseDto("La entrada no puede estar vacía");
        when(primeService.isPrime(emptyInput)).thenReturn(expectedResponse);

        ResponseEntity<ResponseDto> response = primeController.validatePrime(emptyInput);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        assertEquals("La entrada no puede estar vacía", response.getBody().getMessage());
        verify(primeService).isPrime(emptyInput);
    }
}