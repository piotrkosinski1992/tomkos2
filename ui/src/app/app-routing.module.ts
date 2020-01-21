import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './modules/base/login/login.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'logout', redirectTo: 'login'},
  {path: '', redirectTo: 'login', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
