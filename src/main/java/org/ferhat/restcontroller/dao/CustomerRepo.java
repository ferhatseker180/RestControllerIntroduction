package org.ferhat.restcontroller.dao;

import org.ferhat.restcontroller.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Customer findByMail(String mail);

    List<Customer> findByGender(Customer.Gender gender);

    Customer findByMailOrGender(String mail, Customer.Gender gender);
}
