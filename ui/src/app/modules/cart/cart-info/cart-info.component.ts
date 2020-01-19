import {Component, OnDestroy, OnInit} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {CartItem} from '../cart-item';
import {CartState} from '../store/cart.reducers';
import {select, Store} from '@ngrx/store';
import * as cartActions from '../store/cart.actions';
import * as cartSelectors from '../store/cart.selectors';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-cart-info',
  templateUrl: './cart-info.component.html',
  styleUrls: ['./cart-info.component.scss']
})
export class CartInfoComponent implements OnInit, OnDestroy {

  dataSource = new MatTableDataSource<CartItem>();
  displayedColumns = ['isbn', 'title', 'price', 'amount', 'button'];
  subscription: Subscription;
  total = 0;

  constructor(private store: Store<CartState>) {
  }

  ngOnInit() {
    this.store.dispatch(new cartActions.TryLoadCart());
    this.subscription = this.store.pipe(select(cartSelectors.getCart)).subscribe(
      (cartItems: CartItem[]) => {
        this.dataSource.data = cartItems;
        // this.total = this.calculatePrice(cartItems);
      }
    );
  }

  onDeleteItem(isbn: string) {
    this.store.dispatch(new cartActions.TryRemoveFromCart(isbn));
    // TODO da się zrobić jakiś refresh na selectorze?
    window.location.reload();
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  // TODO nie działa bo dane przychodzą z opóźnieniem?
  /*  calculatePrice(cartItems: CartItem[]) {
      return cartItems.map(item => item.amount * item.book.price)
      .reduce((sum, current) => sum + current);
    }*/
}


