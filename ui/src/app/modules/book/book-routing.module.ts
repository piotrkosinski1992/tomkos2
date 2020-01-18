import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {BookListComponent} from './book-list/book-list.component';
import {BookDetailsComponent} from './book-details/book-details.component';

const routes: Routes = [
  {path: 'books/search/:phrase', component: BookListComponent},
  {path: 'books/:isbn', component: BookDetailsComponent},
  {path: 'books', component: BookListComponent} // TODO newest?
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookRoutingModule {
}
