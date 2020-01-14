import { Component, OnInit } from '@angular/core';
import {CartService} from "../../../api/cart.service";

@Component({
  selector: 'app-cart-info',
  templateUrl: './cart-info.component.html',
  styleUrls: ['./cart-info.component.scss']
})
export class CartInfoComponent implements OnInit {

  constructor(private cartService: CartService) { }

  ngOnInit() {
    this.cartService.getCartProducts()
  }

}
