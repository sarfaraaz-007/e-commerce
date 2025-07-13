package com.alibou.ecommerce.order;

import org.apache.kafka.common.protocol.types.Field;

import java.math.BigDecimal;

public record OrderResponse(
        Integer id,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerId

) {
}
