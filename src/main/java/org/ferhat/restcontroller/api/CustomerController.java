package org.ferhat.restcontroller.api;

import org.ferhat.restcontroller.business.abstracts.ICustomerService;
import org.ferhat.restcontroller.dto.CustomerDto;
import org.ferhat.restcontroller.dto.CustomerSaveRequest;
import org.ferhat.restcontroller.dto.CustomerUpdateRequest;
import org.ferhat.restcontroller.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    private final ICustomerService customerService;
    private ModelMapper modelMapper;

    public CustomerController(ICustomerService customerService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> findAll() {
        List<CustomerDto> customerDtoList = this.customerService.findAll().stream().map(
                customer -> this.modelMapper.map(customer, CustomerDto.class)
        ).collect(Collectors.toList());
        return customerDtoList;
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody CustomerSaveRequest customerSaveRequest) {
        Customer newCustomer = this.modelMapper.map(customerSaveRequest, Customer.class);
        newCustomer.setOnDate(LocalDate.now());
        return this.customerService.save(newCustomer);
    }

    /*
    @GetMapping("/customers/{id}")
    public CustomerDto getById(@PathVariable("id") int id) {
        Customer customer = this.customerService.getById(id);
        CustomerDto customerDto = this.converter.convert(customer);
        return customerDto;
    }

     */
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public Customer update(@RequestBody CustomerUpdateRequest customerUpdateRequest) {
        Customer updatedCustomer = this.customerService.getById(customerUpdateRequest.getId());
        updatedCustomer.setName(customerUpdateRequest.getName());
        updatedCustomer.setGender(customerUpdateRequest.getGender());
        return this.customerService.update(updatedCustomer);
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        this.customerService.delete(id);
    }
}
