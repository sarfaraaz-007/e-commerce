package com.alibou.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "Customer firstname is required")
        String firstname,
        @NotNull(message = "Customer Lastname is required")
        String lastname,
        @NotNull(message = "Customer email is required")
        @Email(message = "Customer email is not a valid email")
        String email,
        Address address
) {

}
