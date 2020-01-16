import {Component, OnInit} from '@angular/core';
import {CartService} from '../../../api/cart.service';
import {MatTableDataSource} from '@angular/material/table';
import {Book} from '../../book/book';

@Component({
  selector: 'app-cart-info',
  templateUrl: './cart-info.component.html',
  styleUrls: ['./cart-info.component.scss']
})
export class CartInfoComponent implements OnInit {

  dataSource = new MatTableDataSource<Book>();
  displayedColumns = ['id', 'name', 'price', 'amount', 'button'];

  constructor(private cartService: CartService) {
  }

  ngOnInit() {
    this.cartService.getCartBooks().subscribe(
      (books: any) => this.dataSource.data = books
    );
  }

  onDeleteItem(isbn: string) {
    this.cartService.deleteByIsbn(isbn);
    window.location.reload();
  }
}
