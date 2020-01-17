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
  total = 0;

  constructor(private cartService: CartService) {
  }

  ngOnInit() {
    this.cartService.getCartBooks().subscribe(
      (books: any) => {
        this.dataSource.data = books;
        this.total = this.calculatePrice();
      }
    );
  }

  onDeleteItem(isbn: string) {
    this.cartService.deleteByIsbn(isbn);
    window.location.reload();
  }

  calculatePrice() {
    // TODO zmiana price na backendzie bez dollara
    return this.dataSource.data.map(book => book.amount * book.price)
    .reduce((sum, current) => sum + current);
  }
}


