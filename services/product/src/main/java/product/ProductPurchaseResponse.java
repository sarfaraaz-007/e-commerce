package product;

import java.math.BigDecimal;

public record ProductPurchaseResponse(
        Integer ProductId,
        String name,
        String description,
        BigDecimal price,
        Double quantity
) {
}
