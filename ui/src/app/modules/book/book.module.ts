import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MaterialModule} from '../../material.module';
import {BaseRoutingModule} from '../base/base-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {BookListComponent} from './book-list/book-list.component';
import {BookItemComponent} from './book-list/book-item/book-item.component';
import {BookDetailsComponent} from './book-details/book-details.component';
import {BookRoutingModule} from './book-routing.module';


@NgModule({
  declarations: [BookListComponent, BookItemComponent, BookDetailsComponent],
  imports: [
    MaterialModule,
    CommonModule,
    BaseRoutingModule,
    HttpClientModule,
    BookRoutingModule
  ]
})
export class BookModule {
}
