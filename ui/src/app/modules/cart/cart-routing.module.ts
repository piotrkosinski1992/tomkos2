import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {CartInfoComponent} from './cart-info/cart-info.component';
import {AuthGuard} from '../base/login/auth.guard';

const routes: Routes = [
  {path: '', component: CartInfoComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CartRoutingModule {
}
