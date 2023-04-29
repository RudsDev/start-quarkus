package br.org.ruds.controllers;

import java.util.List;
import java.util.Optional;

import br.org.ruds.entitys.Company;
import br.org.ruds.services.CompanyService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/company")
public class CompanyController {
    
    @Inject
    CompanyService service;


    @POST
    @Transactional
    public Response saveCompany(Company company) {
        Optional<Company> persisted = service.save(company);

        if (persisted.isPresent()) {
            return Response.created(null).entity(persisted).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    public Response findAll() {
        Optional<List<Company>> companies = service.getAll();

        if (companies.isPresent()) {
            return Response.ok(null).entity(companies).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
