package com.vcareer.supportiq.repository;

import com.vcareer.supportiq.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}