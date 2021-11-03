package com.car.market.service

import com.car.market.model.Customer
import org.springframework.stereotype.Service

@Service
class CustomerService {

    val customers = mutableListOf<Customer>()

    fun getAllCustomers(name: String?): List<Customer> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun getOneCustomer(id: String): Customer {
        return customers.first { it.id == id }
    }

    fun createCustomer(customer: Customer) {
        val id = if(customers.isEmpty()) {
            1
        } else {
            customers.last().id!!.toInt() + 1
        }.toString()
        customer.id = id
        customers.add(customer)
    }

    fun updateCustomer(customer: Customer) {
        customers.first { it.id == customer.id }.let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun deleteCustomer(id: String) {
        customers.removeIf { it.id == id }
    }
}