package com.ecommerce.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.product.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
