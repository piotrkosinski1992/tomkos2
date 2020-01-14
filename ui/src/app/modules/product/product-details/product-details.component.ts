import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Product} from "../product";
import {CartService} from "../../../api/cart.service";
import {Location} from "@angular/common"

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss']
})
export class ProductDetailsComponent implements OnInit {

  product: Product;
  constructor(private activatedRoute: ActivatedRoute, private location: Location, private cartService: CartService) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe((product: Product) => {
      this.product = product
    });
  }

  onBuyClick(amount: string) {
    this.cartService.addToCart(this.product.id, amount);
  }

  onBackClick() {
    this.location.back();
  }
}
