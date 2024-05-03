package org.ferhat.restcontroller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ferhat.restcontroller.entity.Customer;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest {

    private String name;
    private String mail;
    private Customer.Gender gender;
}
