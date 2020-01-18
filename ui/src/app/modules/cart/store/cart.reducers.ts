import {CartActions, CartActionTypes} from './cart.actions';
import {CartItem} from '../cart-item';

export interface CartState {
  cart: CartItem[];
}

export const cartInitState: CartState = {
  cart: []
};

export function cartReducers(state = cartInitState, action: CartActions) {
  switch (action.type) {
    case CartActionTypes.LOAD_CART_SUCCESS: {
      return {
        ...state,
        cart: action.cartItems
      };
    }
    default:
      return {
        ...state
      };
  }
}
