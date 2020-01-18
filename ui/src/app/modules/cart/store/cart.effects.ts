import {Injectable} from '@angular/core';
import {Actions, Effect, ofType} from '@ngrx/effects';
import {Observable, of} from 'rxjs';
import {Action} from '@ngrx/store';
import * as cartActions from './cart.actions';
import {CartActionTypes, TryAddToCart, TryRemoveFromCart} from './cart.actions';
import {catchError, map, mergeMap} from 'rxjs/operators';
import {CartService} from '../../../api/cart.service';
import {CartItem} from '../cart-item';


@Injectable()
export class CartEffects {

  constructor(private actions$: Actions, private cartService: CartService) {
  }

  @Effect()
  addCartItem: Observable<Action> = this.actions$.pipe(ofType(CartActionTypes.TRY_ADD_TO_CART),
    mergeMap((actionInput: TryAddToCart) => this.cartService.addToCart(actionInput.isbn, actionInput.amount).pipe(
      map(() => {
        alert('Book added to cart!')
        return new cartActions.AddToCartSuccess();
      }),
      catchError(err => {
        console.log(err);
        return of(null);
      })
    )));

  @Effect()
  removeCartItem: Observable<Action> = this.actions$.pipe(ofType(CartActionTypes.TRY_REMOVE_FROM_CART),
    mergeMap((actionInput: TryRemoveFromCart) => this.cartService.removeByIsbn(actionInput.isbn).pipe(
      map(() => new cartActions.RemoveFromCartSuccess()),
      catchError(err => {
        console.log(err);
        return of(null);
      })
    )));

  @Effect()
  getCart: Observable<Action> = this.actions$.pipe(ofType(CartActionTypes.TRY_LOAD_CART),
    mergeMap(() => this.cartService.getCart().pipe(
      map((cartItems: CartItem[]) => new cartActions.LoadCartSuccess(cartItems)),
      catchError(err => {
        console.log(err);
        return of(null);
      })
    )));
}
