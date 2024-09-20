package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrimeNumberService {

    /**
     * This method calculates a list of prime numbers up to a given range.
     *
     * @param range The upper limit for checking prime numbers.
     *
     * @return A list of prime numbers within the given range.
     *
     * @throws IllegalArgumentException If the range is less than or equal to 0.
     */
    public List<Integer> calculatePrimeNumbersList(int range) {
        if (range <= 0 || range > 1000000) {
            throw new IllegalArgumentException("Please enter a positive, non-zero integer less than 1000000.");
        }

        List<Integer> primes = new ArrayList<>();
        // Loop through numbers from 2 to the given range and check if they are prime
        for (int i = 2; i <= range; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        // Return the result
        return primes;
    }

    /**
     * This method checks if a given number is a prime number.
     *
     * @param number The number to be checked.
     * @return True if the number is prime, otherwise false.
     */
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        /*
        Here we optimize the loop: instead of checking every number from 2 to n, which is inefficient,
        we check divisibility only up to the square root of the number.
        For example, for number = 37:
        1. Iteration: 2 x 2 = 4
        2. Iteration: 3 x 3 = 9
        3. Iteration: 4 x 4 = 16
        4. Iteration: 5 x 5 = 25
        5. Iteration: 6 x 6 = 36
        This way, we skip unnecessary steps, and the loop runs fewer times.
        */
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
