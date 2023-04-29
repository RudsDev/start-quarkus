package br.org.ruds.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Company {
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;

    private String registry;

    private String phone;
}
