import {CartState} from './cart.reducers';
import {createFeatureSelector, createSelector} from '@ngrx/store';

export const cartFeature = 'cart';

const getCartFeatureState = createFeatureSelector<CartState>(cartFeature);

export const getCart = createSelector(
  getCartFeatureState,
  (state: CartState) => state.cart
);

