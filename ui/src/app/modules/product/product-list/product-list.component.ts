import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {ProductService} from "../../../api/product.service";
import {Product} from "../product";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit, OnDestroy {

  products: Product[];
  subscription: Subscription;

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.subscription = this.productService.getProducts().subscribe((products: Product[]) => {
      this.products = products
    })
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  productsExists() {
    return this.products.length > 0;
  }
}
