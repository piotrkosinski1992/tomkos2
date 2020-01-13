package com.tomkos2.inventory.app.usecase;

import com.tomkos2.inventory.app.domain.Product;
import com.tomkos2.inventory.app.domain.Response;
import com.tomkos2.inventory.app.repo.ProductRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class InventoryUsecase {

  private final ProductRepository repository;

  public InventoryUsecase(ProductRepository repository) {
    this.repository = repository;
  }

  public boolean isProductInStock(Long id) {
    Product product = findById(id);
    return product.getAmount() > 0;
  }

  @Transactional
  public Response decreaseProductAmount(Product product) {
    Product inventoryProduct = findById(product.getId());
    if (!inventoryProduct.decreaseAmount(product.getAmount())) {
      return Response.Error(
          "There is less product than requested inside inventory: " + inventoryProduct.getAmount());
    }
    return Response.Ok();
  }

  private Product findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product with given id " + id + " not found"));
  }
}
