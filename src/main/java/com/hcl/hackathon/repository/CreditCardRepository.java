package com.hcl.hackathon.repository;
import com.hcl.hackathon.entity.ApplicationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<ApplicationDetail, Integer> {
}
