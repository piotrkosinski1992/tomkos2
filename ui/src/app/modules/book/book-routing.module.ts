import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {BookListComponent} from './book-list/book-list.component';
import {BookDetailsComponent} from './book-details/book-details.component';

const routes: Routes = [
  {path: 'search/:phrase', component: BookListComponent},
  {path: ':isbn', component: BookDetailsComponent},
  {path: '', component: BookListComponent}
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookRoutingModule {
}
