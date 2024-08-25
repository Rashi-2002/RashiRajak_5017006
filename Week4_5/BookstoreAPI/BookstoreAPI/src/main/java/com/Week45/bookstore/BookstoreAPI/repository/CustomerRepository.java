package com.Week45.bookstore.BookstoreAPI.repository;

import com.Week45.bookstore.BookstoreAPI.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}




