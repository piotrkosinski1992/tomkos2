import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {CartInfoComponent} from "./cart-info/cart-info.component";

const routes: Routes = [
  {path: 'cart', component: CartInfoComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CartRoutingModule {
}
