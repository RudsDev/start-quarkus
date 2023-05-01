package br.org.ruds.controllers;

import org.junit.jupiter.api.Test;

import br.org.ruds.entitys.Company;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response.Status;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

@QuarkusTest
public class CompanyControllerTest {
    final private String PREFIX = "/company";
    
    @Test
    public void testSaveCompanyEndpoint() throws Exception {
        Company company = createCompany();

        given()
            .contentType("application/json")
            .body(company)
            .when()
            .post(PREFIX)
                .then()
                .statusCode(Status.CREATED.getStatusCode())
                .body("name", equalTo("Test Company"))
                .body("registry", equalTo("0000000"))
                .body("address", equalTo("Street Test, 000"))
                .body("phone", equalTo("+00 00 00000000"));

    }

    @Test
    public void testFindAllEndpoint() throws Exception {

        when()
            .get(PREFIX)
                .then()
                .statusCode(Status.OK.getStatusCode())
                .body("size()", greaterThanOrEqualTo(0));
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
