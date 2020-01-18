import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {NgModule} from '@angular/core';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'logout', redirectTo: 'login'},
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  /*    {
        path: '', canActivate: [AuthGuard], children: [
          {
            path: 'books',
            loadChildren: 'src/app/modules/book/book.module#BookModule'
          },
        ]
      }*/
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BaseRoutingModule {
}
