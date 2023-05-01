package br.org.ruds.utils;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalcUtils {
    
    public boolean calcPrimeNumber(int number) {
        if (number <= 1) return false;
        for (int i = 2; i < number; i++) if(number % i == 0) return false;
        return true;
    }

}
