package ru.vallione.simple_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vallione.simple_rest.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findByName(String companyName);
}
