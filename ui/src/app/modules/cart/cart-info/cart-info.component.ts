import {Component, OnInit} from '@angular/core';
import {CartService} from '../../../api/cart.service';
import {MatTableDataSource} from '@angular/material/table';
import {Product} from '../../product/product';

@Component({
  selector: 'app-cart-info',
  templateUrl: './cart-info.component.html',
  styleUrls: ['./cart-info.component.scss']
})
export class CartInfoComponent implements OnInit {

  dataSource = new MatTableDataSource<Product>();
  displayedColumns = ['id', 'name', 'price', 'amount', 'button'];

  constructor(private cartService: CartService) {
  }

  ngOnInit() {
    this.cartService.getCartProducts().subscribe(
      (products: any) => this.dataSource.data = products
    );
  }

  onDeleteItem(id: number) {
    this.cartService.deleteByProductId(id);
    window.location.reload();
  }
}
