package com.tomkos2.inventory.app.web;

import com.tomkos2.inventory.app.domain.Product;
import com.tomkos2.inventory.app.domain.Response;
import com.tomkos2.inventory.app.usecase.InventoryUsecase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

  private final InventoryUsecase usecase;

  public InventoryController(InventoryUsecase usecase) {
    this.usecase = usecase;
  }

  @PostMapping("/decrease")
  public Response decreaseProductAmount(@RequestBody Product product) {
    return usecase.decreaseProductAmount(product);
  }

  @GetMapping("/id/{id}/instock")
  public boolean isProductInStock(@PathVariable Long id) {
    return usecase.isProductInStock(id);
  }
}
