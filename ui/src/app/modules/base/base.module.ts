import {NgModule} from '@angular/core';
import {ReactiveFormsModule} from "@angular/forms";
import {LoginComponent} from "./login/login.component";
import {MaterialModule} from "../../material.module";
import {CommonModule} from "@angular/common";
import {NavbarComponent} from "./navbar/navbar.component";
import {LayoutComponent} from "./layout/layout.component";
import {BaseRoutingModule} from "./base-routing.module";
import {HttpClientModule} from "@angular/common/http";
import { LogoutComponent } from './logout/logout.component';


@NgModule({
  declarations: [
    LoginComponent,
    NavbarComponent,
    LayoutComponent,
    LogoutComponent,
  ],
  imports: [
    ReactiveFormsModule,
    MaterialModule,
    CommonModule,
    BaseRoutingModule,
    HttpClientModule
  ],
  exports: [LayoutComponent]
})
export class BaseModule {
}
