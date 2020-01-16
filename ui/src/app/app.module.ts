import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {BaseModule} from './modules/base/base.module';
import {BookService} from './api/book.service';
import {AuthInterceptor} from './modules/base/login/auth-interceptor.service';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {CartModule} from './modules/cart/cart.module';
import {BookModule} from './modules/book/book.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    BaseModule,
    BookModule,
    CartModule
  ],
  providers: [BookService,
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
