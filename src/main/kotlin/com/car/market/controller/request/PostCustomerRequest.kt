package com.car.market.controller.request

import com.car.market.model.Customer

data class PostCustomerRequest (
    var name: String,
    var email: String
)