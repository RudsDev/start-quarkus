package br.org.ruds.services.mock;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.org.ruds.services.MyUtilsService;
import br.org.ruds.utils.CalcUtils;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MyUtilsServiceMockTest {
    
    @InjectMocks
    private MyUtilsService service;

    @Mock
    private CalcUtils calcUtils;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void isPrimeNumber() {
        Integer primeNumber = 5;
        Integer noPrimeNumber = 1;

        when(calcUtils.calcPrimeNumber(primeNumber)).thenReturn(true);
        when(calcUtils.calcPrimeNumber(noPrimeNumber)).thenReturn(false);

        Boolean isTrue = service.isPrimeNumber(primeNumber);
        Boolean isFalse = service.isPrimeNumber(noPrimeNumber);

        Assertions.assertEquals(true, isTrue);
        Assertions.assertEquals(false, isFalse);

    }
}
