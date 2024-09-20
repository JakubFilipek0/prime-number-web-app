package com.example.demo.controller;

import com.example.demo.service.PrimeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PrimeNumberController {

    @Autowired
    private PrimeNumberService primeNumberService;

    /**
     * GET method that returns the HTML file with the form.
     *
     * @return the "home" HTML file
     */
    @GetMapping("/")
    public String index() {
        return "home";
    }

    /**
     * POST method that calls the calculatePrimeNumbersList function from the service
     * to generate a list of prime numbers based on the range provided by the user.
     *
     * @param range The range up to which the program should check for prime numbers
     * @param model The model object used to pass values to the HTML file
     *
     * @return the "home" HTML file
     */
    @PostMapping("/calculate")
    public String calculatePrimes(@RequestParam("range") int range, Model model) {
        try {
            List<Integer> primes = primeNumberService.calculatePrimeNumbersList(range);
            model.addAttribute("primes", primes);
            model.addAttribute("range", range);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "home";
    }
}
