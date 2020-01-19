import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MaterialModule} from '../../material.module';
import {BaseRoutingModule} from '../base/base-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {BookListComponent} from './book-list/book-list.component';
import {BookItemComponent} from './book-list/book-item/book-item.component';
import {BookDetailsComponent} from './book-details/book-details.component';
import {BookRoutingModule} from './book-routing.module';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {bookFeature} from './store/book.selectors';
import {bookReducers} from './store/book.reducers';
import {BookEffects} from './store/book.effects';
import { BookCategoriesComponent } from './book-list/book-categories/book-categories.component';


@NgModule({
  declarations: [BookListComponent, BookItemComponent, BookDetailsComponent, BookCategoriesComponent],
  imports: [
    MaterialModule,
    CommonModule,
    BaseRoutingModule,
    HttpClientModule,
    BookRoutingModule,
    StoreModule.forFeature(bookFeature, bookReducers),
    EffectsModule.forFeature([BookEffects]),
  ]
})
export class BookModule {
}
