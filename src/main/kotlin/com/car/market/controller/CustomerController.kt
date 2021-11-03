package com.car.market.controller

import com.car.market.controller.request.PostCustomerRequest
import com.car.market.controller.request.PutCustomerRequest
import com.car.market.extension.convertToCustomer
import com.car.market.model.Customer
import com.car.market.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class CustomerController(
    val customerService: CustomerService
) {

    @GetMapping
    fun getAllCustomer(@RequestParam name: String?): List<Customer> {
        return customerService.getAllCustomers(name);
    }

    @GetMapping("/{id}")
    fun getOneCustomer(@PathVariable id: String): Customer {
        return customerService.getOneCustomer(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest) {
        customerService.createCustomer(customer.convertToCustomer())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: String, @RequestBody customer: PutCustomerRequest) {
        customerService.updateCustomer(customer.convertToCustomer(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: String) {
        customerService.deleteCustomer(id)
    }
}