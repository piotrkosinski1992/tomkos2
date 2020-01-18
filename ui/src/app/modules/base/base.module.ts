import {NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {LoginComponent} from './login/login.component';
import {MaterialModule} from '../../material.module';
import {CommonModule} from '@angular/common';
import {NavbarComponent} from './navbar/navbar.component';
import {LayoutComponent} from './layout/layout.component';
import {BaseRoutingModule} from './base-routing.module';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AuthInterceptor} from './login/auth-interceptor.service';


@NgModule({
  declarations: [
    LoginComponent,
    NavbarComponent,
    LayoutComponent,
  ],
  imports: [
    ReactiveFormsModule,
    MaterialModule,
    CommonModule,
    BaseRoutingModule,
    HttpClientModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  exports: [LayoutComponent]
})
export class BaseModule {
}
