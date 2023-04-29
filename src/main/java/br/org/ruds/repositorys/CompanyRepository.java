package br.org.ruds.repositorys;

import java.util.Optional;

import br.org.ruds.entitys.Company;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CompanyRepository implements PanacheRepository<Company> {
    
    @Inject
    private CompanyRepository repository;

    public Optional<Company> saveCompany(Company new_) {   
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
