import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {AuthGuard} from './login/auth.guard';

const routes: Routes = [
  {
    path: 'cart', canActivate: [AuthGuard], children: [
      {
        path: '',
        loadChildren: 'src/app/modules/cart/cart.module#CartModule'
      },
    ]
  },
  {
    path: 'books', canActivate: [AuthGuard], children: [
      {
        path: '',
        loadChildren: 'src/app/modules/book/book.module#BookModule'
      },
    ]
  }
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BaseRoutingModule {
}
