package org.example.service;

import org.example.dto.InvalidNumberException;
import org.example.dto.ResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PrimeImplTest {

    private PrimeImpl primeService;

    @BeforeEach
    void setUp() {
        primeService = new PrimeImpl();
    }

    @Test
    void isPrime_WhenNumberIs2_ShouldReturnPrimeMessage() {
        String number = "2";

        ResponseDto response = primeService.isPrime(number);

        assertEquals("2 es un número primo.", response.getMessage());
    }

    @Test
    void isPrime_WhenInputIsNotANumber_ShouldThrowInvalidNumberException() {
        String invalidInput = "abc";

        InvalidNumberException exception = assertThrows(
                InvalidNumberException.class,
                () -> primeService.isPrime(invalidInput)
        );
        assertEquals("Entrada inválida abc. Debe ser un número entero.", exception.getMessage());
    }

    @Test
    void isPrime_WhenInputIsEmpty_ShouldThrowInvalidNumberException() {
        String emptyInput = "";

        InvalidNumberException exception = assertThrows(
                InvalidNumberException.class,
                () -> primeService.isPrime(emptyInput)
        );
        assertEquals("Entrada inválida . Debe ser un número entero.", exception.getMessage());
    }

    @Test
    void isPrime_WhenInputHasSpaces_ShouldThrowInvalidNumberException() {
        String inputWithSpaces = " 23 ";

        InvalidNumberException exception = assertThrows(
                InvalidNumberException.class,
                () -> primeService.isPrime(inputWithSpaces)
        );
        assertEquals("Entrada inválida  23 . Debe ser un número entero.", exception.getMessage());
    }

    @Test
    void isPrime_WhenInputIsLargeNumber_ShouldWorkCorrectly() {
        String largeNumber = "997";

        ResponseDto response = primeService.isPrime(largeNumber);

        assertEquals("997 es un número primo.", response.getMessage());
    }
}