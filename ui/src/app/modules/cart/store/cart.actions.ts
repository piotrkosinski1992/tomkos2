import {Action} from '@ngrx/store';
import {CartItem} from '../cart-item';

export enum CartActionTypes {
  TRY_LOAD_CART = '[cart] try load cart',
  LOAD_CART_SUCCESS = '[cart] load cart success',
  LOAD_CART_FAILED = '[cart] load cart failed',

  TRY_ADD_TO_CART = '[cart] try add to cart',
  ADD_TO_CART_SUCCESS = '[cart] add to cart success',
  ADD_TO_CART_FAILED = '[cart] add to cart failed',

  TRY_REMOVE_FROM_CART = '[cart] try remove from cart',
  REMOVE_FROM_CART_SUCCESS = '[cart] remove from cart success',
  REMOVE_FROM_CART_FAILED = '[cart] remove from cart failed',

}

export class TryLoadCart implements Action {
  readonly type = CartActionTypes.TRY_LOAD_CART;
}


export class LoadCartSuccess implements Action {
  readonly type = CartActionTypes.LOAD_CART_SUCCESS;

  constructor(public cartItems: CartItem[]) {
  }
}

export class TryAddToCart implements Action {
  readonly type = CartActionTypes.TRY_ADD_TO_CART;

  constructor(public isbn: string, public amount: string) {
  }
}

export class AddToCartSuccess implements Action {
  readonly type = CartActionTypes.ADD_TO_CART_SUCCESS;
}

export class TryRemoveFromCart {
  readonly type = CartActionTypes.TRY_REMOVE_FROM_CART;

  constructor(public isbn: string) {
  }
}

export class RemoveFromCartSuccess {
  readonly type = CartActionTypes.REMOVE_FROM_CART_SUCCESS;
}

export type CartActions =
  TryLoadCart |
  LoadCartSuccess |
  TryAddToCart |
  AddToCartSuccess |
  TryRemoveFromCart |
  RemoveFromCartSuccess;
