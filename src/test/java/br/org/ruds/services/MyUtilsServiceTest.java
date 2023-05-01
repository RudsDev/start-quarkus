package br.org.ruds.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class MyUtilsServiceTest {
    
    @Inject
    MyUtilsService service;

    @Test
    public void testIsPrimeNumber() {
        Integer primeNumber = 5;
        Integer noPrimeNumber = 1;

        Assertions.assertEquals(true, service.isPrimeNumber(primeNumber));
        Assertions.assertEquals(false, service.isPrimeNumber(noPrimeNumber));
    }

    @Test
    public void testCountCharacters() {
        Assertions.assertEquals(7, service.countCharacters("Test Ok"));
        Assertions.assertEquals(6, service.countCharacters("TestOk"));
    }

}
