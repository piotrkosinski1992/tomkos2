import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CartInfoComponent } from './cart-info/cart-info.component';
import {CartRoutingModule} from "./cart-routing.module";
import {MaterialModule} from "../../material.module";



@NgModule({
  declarations: [CartInfoComponent],
  imports: [
    CommonModule,
    CartRoutingModule,
    MaterialModule
  ]
})
export class CartModule { }
