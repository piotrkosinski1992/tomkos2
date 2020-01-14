import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MaterialModule} from "../../material.module";
import {BaseRoutingModule} from "../base/base-routing.module";
import {HttpClientModule} from "@angular/common/http";
import {ProductListComponent} from './product-list/product-list.component';
import {ProductRoutingModule} from "./product-routing.module";
import {ProductItemComponent} from './product-list/product-item/product-item.component';
import {ProductDetailsComponent} from "./product-details/product-details.component";


@NgModule({
  declarations: [ProductListComponent, ProductItemComponent, ProductDetailsComponent],
  imports: [
    MaterialModule,
    CommonModule,
    BaseRoutingModule,
    HttpClientModule,
    ProductRoutingModule
  ]
})
export class ProductModule {
}
