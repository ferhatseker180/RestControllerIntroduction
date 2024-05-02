package org.ferhat.restcontroller.api;

import org.ferhat.restcontroller.business.abstracts.ICustomerService;
import org.ferhat.restcontroller.business.impl.CustomerManager;
import org.ferhat.restcontroller.dao.CustomerRepo;
import org.ferhat.restcontroller.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable("id") int id) {
        return customerService.getById(id);
    }
}
