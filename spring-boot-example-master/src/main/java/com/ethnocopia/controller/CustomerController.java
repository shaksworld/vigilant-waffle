package com.ethnocopia.controller;

import com.ethnocopia.DTO.CustomerDto;
import com.ethnocopia.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/create")
    public ResponseEntity<CustomerDto> createCustomer (CustomerDto customerDto){
        return  new ResponseEntity<>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }

//    @PostMapping
//    public void addCustomer(@RequestBody Main.NewCustomerRequest request) {
//        Customer customer = new Customer();
//        customer.setName(request.name);
//        customer.setEmail(request.email);
//        customer.setAge(request.age);
//
//        customerRepository.save(customer);
//    }
//
//    @DeleteMapping("{customerId}")
//    public void deleteCustomer(@PathVariable("customerId") Integer id) {
//        customerRepository.deleteById(id);
//    }
//
//    @PutMapping("{customerId}")
//    public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody Main.NewCustomerRequest request) {
//        Optional<Customer> customerWrapper = customerRepository.findById(id);
//        if (!customerWrapper.isPresent())
//            return;
//
//        Customer customer = customerWrapper.get();
//        customer.setName(request.name);
//        customer.setAge(request.age);
//        customer.setEmail(request.email);
//
//        customerRepository.save(customer);
//    }
//    @GetMapping
//    public List<Customer> getCustomers() {
//        return customerRepository.findAll();
//    }
}
