package tn.esprit.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.BookStore.model.ZipCodesTN;

import java.util.*;

public interface ZipCodesTnRepository extends JpaRepository<ZipCodesTN,String> {



}
