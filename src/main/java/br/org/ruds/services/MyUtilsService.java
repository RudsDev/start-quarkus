package br.org.ruds.services;

import br.org.ruds.utils.CalcUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MyUtilsService {
    
    @Inject
    CalcUtils calcUtils;

    public boolean isPrimeNumber(int number) {
        return calcUtils.calcPrimeNumber(number);
    }

    public int countCharacters(String input) {
        return input.length();
    }
}
