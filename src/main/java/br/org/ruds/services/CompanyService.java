package br.org.ruds.services;

import java.util.Optional;

import br.org.ruds.entitys.Company;
import br.org.ruds.repositorys.CompanyRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CompanyService {
    
    @Inject
    private CompanyRepository repository;

    public Optional<Company> save(Company new_) {   
        try {
            repository.persist(new_);
            int listSize = repository.listAll().size();
            Company persisted = repository.listAll().get(listSize-1);
            return Optional.of(persisted);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
