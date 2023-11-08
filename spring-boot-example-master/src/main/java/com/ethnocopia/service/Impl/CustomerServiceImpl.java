package com.ethnocopia.service.Impl;

import com.ethnocopia.DTO.CustomerDto;
import com.ethnocopia.entity.Customer;
import com.ethnocopia.repository.CustomerRepository;
import com.ethnocopia.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = mapToEntity(customerDto);
        Customer newCustomer = customerRepository.save(customer);

        CustomerDto customerResponse = mapToDto(newCustomer);
        return customerResponse;
    }
    private CustomerDto mapToDto (Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setAge(customer.getAge());
        return customerDto;
    }

    private Customer mapToEntity (CustomerDto customerDto){

        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setAge(customerDto.getAge());

        return customer;
    }
}
