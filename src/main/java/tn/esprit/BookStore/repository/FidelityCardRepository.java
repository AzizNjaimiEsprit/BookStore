package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.BookStore.model.FidelityCard;

@Repository
public interface FidelityCardRepository extends JpaRepository<FidelityCard, Long> {
    FidelityCard findByUserId (long userId);
}
