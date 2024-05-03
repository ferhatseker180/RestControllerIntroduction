package org.ferhat.restcontroller.api;

import org.ferhat.restcontroller.business.abstracts.ICustomerService;
import org.ferhat.restcontroller.dto.CustomerDto;
import org.ferhat.restcontroller.dto.CustomerDtoConverter;
import org.ferhat.restcontroller.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    private final ICustomerService customerService;
    private final CustomerDtoConverter converter;
    private ModelMapper modelMapper;

    public CustomerController(ICustomerService customerService, CustomerDtoConverter converter, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.converter = converter;
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
    public Customer save(@RequestBody Customer customer) {
        return this.customerService.save(customer);
    }

    @GetMapping("/customers/{id}")
    public CustomerDto getById(@PathVariable("id") int id) {
        Customer customer = this.customerService.getById(id);
        CustomerDto customerDto = this.converter.convert(customer);
        return customerDto;
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public Customer update(@RequestBody Customer customer) {
        return this.customerService.update(customer);
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        this.customerService.delete(id);
    }
}
