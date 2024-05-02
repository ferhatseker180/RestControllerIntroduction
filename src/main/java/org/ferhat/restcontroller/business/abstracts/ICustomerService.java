package org.ferhat.restcontroller.business.abstracts;

import org.ferhat.restcontroller.entity.Customer;

public interface ICustomerService {
    Customer getById(int id);
    Customer save(Customer customer);
    void delete(Customer customer);
    Customer update(Customer customer);
}
