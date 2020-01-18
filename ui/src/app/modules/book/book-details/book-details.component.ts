import {Component, OnInit} from '@angular/core';
import {BookDetails} from '../book-details';
import {Observable} from 'rxjs';
import {select, Store} from '@ngrx/store';
import * as bookSelectors from '../store/book.selectors';
import {BookState} from '../store/book.reducers';
import {Location} from '@angular/common';
import * as cartActions from '../../cart/store/cart.actions';
import * as bookActions from '../store/book.actions';
import {ActivatedRoute} from '@angular/router';
import {CartState} from '../../cart/store/cart.reducers';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.scss']
})
export class BookDetailsComponent implements OnInit {

  bookDetails$: Observable<BookDetails>;
  isbn: string;

  constructor(private bookStore: Store<BookState>, private cartStore: Store<CartState>,
              private location: Location, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.isbn = this.route.snapshot.paramMap.get('isbn');
    this.bookStore.dispatch(new bookActions.TryLoadBookDetails(this.isbn));
    this.bookDetails$ = this.bookStore.pipe(select(bookSelectors.getBookDetails));
  }

  onBuyClick(amount: string) {
    this.cartStore.dispatch(new cartActions.TryAddToCart(this.isbn, amount));
  }

  onBackClick() {
    this.location.back();
  }
}
