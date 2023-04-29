package br.org.ruds.controllers;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response.Status;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MyUtilsControllerTest {
    final private String PREFIX = "/util";

    @Test
    public void testPrimeisTrue() throws Exception {
        String primeNumber = "5";
        String path = PREFIX + "/validate/prime/number/" + primeNumber;
        given()
            .when()
            .get(path)
            .then()
                .statusCode(Status.OK.getStatusCode())
                .body(is("true"));
    }

    @Test
    public void testPrimeisFalse() throws Exception {
        String noPrimeNumber = "1";
        String path = PREFIX + "/validate/prime/number/" + noPrimeNumber;
        given()
            .when()
            .get(path)
            .then()
                .statusCode(Status.OK.getStatusCode())
                .body(is("false"));
    }

    @Test
    public void testCountCharacters() throws Exception {
        String input = "Trololo";
        String size = "7";
        String path = PREFIX + "/count/" + input;
        given()
            .when()
            .get(path)
            .then()
                .statusCode(Status.OK.getStatusCode())
                .body(is(size));
    }

}
