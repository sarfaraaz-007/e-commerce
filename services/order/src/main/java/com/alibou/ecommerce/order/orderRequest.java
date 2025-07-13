package com.alibou.ecommerce.order;

import com.alibou.ecommerce.product.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record orderRequest(
        Integer id,
        String reference,
        @Positive(message = "Order amount should be positive")
        BigDecimal amount,
        @NotNull(message = "Payment method should not be null")
        PaymentMethod paymentMethod,
        @NotBlank(message = "customer should be present")
        String customerId,
        @NotEmpty(message = "you should purchase atleast one product")
        List<PurchaseRequest> products
) {
}
