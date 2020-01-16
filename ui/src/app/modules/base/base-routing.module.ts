import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {NgModule} from '@angular/core';
import {LogoutComponent} from "./logout/logout.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent},
  /*  {
      path: '', canActivate: [AuthGuard], children: [
        {
          path: 'books',
          loadChildren: 'src/app/modules/bookDetails/bookDetails.module#ProductModule'
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
