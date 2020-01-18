import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CartInfoComponent} from './cart-info/cart-info.component';
import {CartRoutingModule} from './cart-routing.module';
import {MaterialModule} from '../../material.module';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {cartFeature} from './store/cart.selectors';
import {cartReducers} from './store/cart.reducers';
import {CartEffects} from './store/cart.effects';


@NgModule({
  declarations: [CartInfoComponent],
  imports: [
    CommonModule,
    CartRoutingModule,
    MaterialModule,
    StoreModule.forFeature(cartFeature, cartReducers),
    EffectsModule.forFeature([CartEffects]),
  ]
})
export class CartModule {
}
