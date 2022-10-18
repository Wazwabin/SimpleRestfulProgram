package ru.vallione.simple_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vallione.simple_rest.model.Ceo;

import java.util.List;

@Repository
public interface CeoRepository extends JpaRepository<Ceo, Integer> {
    List<Ceo> findAll();
    Ceo findById(int id);
    Ceo findByName(String name);
}
