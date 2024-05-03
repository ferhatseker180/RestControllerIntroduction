package org.ferhat.restcontroller.dto;

import org.ferhat.restcontroller.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    public CustomerDto convert(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getMail()
        );
    }
}
