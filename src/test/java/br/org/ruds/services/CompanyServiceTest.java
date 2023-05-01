package br.org.ruds.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.org.ruds.entitys.Company;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class CompanyServiceTest {

    @Inject
    CompanyService service;

    @Test
    @TestTransaction
    public void testSave() {
        Company company = createCompany();
        Optional<Company> actual = service.save(company);
        Optional<Company> expected = Optional.of(company);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @TestTransaction
    public void testSavePassingNull() {
        Company company = null;
        Optional<Company> actual = service.save(company);
        Optional<Company> expected = Optional.empty();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @TestTransaction
    public void testFindAll() {
        Company company = createCompany();        
        service.save(company);
        
        List<Company> companies = new ArrayList<>();
        companies.add(company);

        Optional<List<Company>> expected = Optional.of(companies);
        Optional<List<Company>> actual = service.getAll();

        Assertions.assertEquals(expected, actual);
    }

    private Company createCompany() {
        Company company = new Company();
        company.setName("Test Company");
        company.setRegistry("0000000");
        company.setAddress("Street Test, 000");
        company.setPhone("+00 00 00000000");
        return company;
    }
}
