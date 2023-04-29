package br.org.ruds.services;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyUtilsService {
    
    public boolean isPrimeNumber(int number) {
        if (number <= 1) return false;

        for (int i = 2; i < number; i++) {
            if(number % i == 0) return false;
        }
        return true;
    }

    public int countCharacters(String input) {
        return input.length();
    }
}
