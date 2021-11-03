package com.car.market.extension

import com.car.market.controller.request.PostCustomerRequest
import com.car.market.controller.request.PutCustomerRequest
import com.car.market.model.Customer

fun PostCustomerRequest.convertToCustomer(): Customer {
    return Customer(name = this.name, email = this.email)
}

fun PutCustomerRequest.convertToCustomer(id: String): Customer {
    return Customer(id = id, name = this.name, email = this.email)
}