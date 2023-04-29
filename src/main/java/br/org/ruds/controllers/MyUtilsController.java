package br.org.ruds.controllers;

import br.org.ruds.services.MyUtilsService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/util")
public class MyUtilsController {
    
    @Inject
    MyUtilsService service;

    @GET
    @Path("/validate/prime/number/{number}")
    public Response verifyPrimeNumber(
        @PathParam("number") int number
    ) {
        try {
            return Response.ok(service.isPrimeNumber(number)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/count/{input}")
    public Response countCharacters(
        @PathParam("input") String input
    ) {
        try {
            return Response.ok(service.countCharacters(input)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
