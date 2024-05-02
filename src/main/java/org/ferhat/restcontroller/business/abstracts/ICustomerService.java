package org.ferhat.restcontroller.business.abstracts;

import org.ferhat.restcontroller.entity.Customer;

import java.util.List;

public interface ICustomerService {
    Customer getById(int id);
    Customer save(Customer customer);
    void delete(int id);
    Customer update(Customer customer);
    List<Customer> findAll();
}
