package org.ferhat.restcontroller.business.impl;

import org.ferhat.restcontroller.business.abstracts.ICustomerService;
import org.ferhat.restcontroller.dao.CustomerRepo;
import org.ferhat.restcontroller.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements ICustomerService {

    private final CustomerRepo customerRepo;

    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer getById(int id) {
        return this.customerRepo.findById(id).orElseThrow();
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public void delete(int id) {
        this.customerRepo.delete(this.customerRepo.getById(id));
    }

    @Override
    public Customer update(Customer customer) {
        if (customer.getId() == 0) {
            throw new RuntimeException("Id numaralı bir entity giriniz!");
        }
        return this.customerRepo.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepo.findAll();
    }
}
