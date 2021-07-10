package com.hcl.hackathon.repository;

import com.hcl.hackathon.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CustomerJPARepository extends JpaRepository<Customer, Integer> {

    Customer findByPancard(String pancard);
}
