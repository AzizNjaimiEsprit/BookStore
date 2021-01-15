package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate,Integer> {
}
