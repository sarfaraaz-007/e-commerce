package product;

import exception.ProductPurchaseException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Productservice {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    public Integer createProduct(@Valid ProductRequest request) {
        Product product = mapper.toProduct(request);
        return repository.save(product).getId();
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
        var productIds = request
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();
        var storedProducts = repository.findAllByIdInOrderById(productIds);
        if(productIds.size() != storedProducts.size()){
            throw new ProductPurchaseException("One or more Products does not exists");
        }
        var storesRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();
         var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
         for(int i = 0; i < storedProducts.size(); i++){
             var product = storedProducts.get(i);
             var productRequest = storesRequest.get(i);
             if(product.getAvailableQuantity() < productRequest.quantity()){
                 throw new ProductPurchaseException("Insufficient stock quantity for product with :: " + productRequest.productId());
             }
             var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
             product.setAvailableQuantity(newAvailableQuantity);
             repository.save(product);
             purchasedProducts.add(mapper.toProductPurchaseResponse(product, productRequest.quantity()));

         }
        return null;

    }

    public ProductResponse findById(Integer productId) {
        return repository.findById(productId)
                .map(mapper::toProductReponse)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with the Id :: " + productId));
    }

    public List<ProductResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toProductReponse)
                .collect(Collectors.toList());
    }
}
