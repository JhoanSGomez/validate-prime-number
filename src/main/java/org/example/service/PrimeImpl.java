package org.example.service;

import org.example.dto.InvalidNumberException;
import org.example.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class PrimeImpl implements PrimeService {
    //11 / 2
    //11 / 3
    //.
    //.
    //11 / 10

    public ResponseDto isPrime(String input) {
        try {
            int number = Integer.parseInt(input);
            String message;

            if (number <= 1) {
                message = number + " NO es un número primo.";
            } else {
                boolean isPrime = true;
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }

                message = isPrime ? number + " es un número primo." : number + " NO es un número primo.";
            }

            return new ResponseDto(message);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Entrada inválida " + input + ". Debe ser un número entero.");
        }
    }
}

/*    public ResponseDto isPrime(String input) {
        try {
            int number = Integer.parseInt(input);

            boolean isPrime = number > 1 &&
                    IntStream.rangeClosed(2, (int) Math.sqrt(number))
                            .noneMatch(i -> number % i == 0);

            String message = isPrime ? number + " es un número primo."
                    : number + " NO es un número primo.";

            return new ResponseDto(message);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Entrada inválida " + input + ". Debe ser un número entero.");
        }
    }*/
