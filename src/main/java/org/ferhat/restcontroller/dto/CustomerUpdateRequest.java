package org.ferhat.restcontroller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ferhat.restcontroller.entity.Customer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerUpdateRequest {

    private int id;
    private String name;
    private Customer.Gender gender;

}
