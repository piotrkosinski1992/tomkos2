import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Book} from '../book';
import {ActivatedRoute, Router} from '@angular/router';
import {BookState} from '../store/book.reducers';
import {select, Store} from '@ngrx/store';
import * as bookActions from '../store/book.actions';
import * as bookSelectors from '../store/book.selectors';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {

  books$: Observable<Book[]>;
  phrase: string;

  constructor(private route: ActivatedRoute, private store: Store<BookState>, private router: Router) {
    route.params.subscribe(params => {
      if (params.phrase === undefined) {
        this.store.dispatch(new bookActions.TryLoadNewestBooks());
      } else {
        this.store.dispatch(new bookActions.TryLoadBooksByPhrase(params.phrase));
      }
    });
  }

  ngOnInit() {
    this.books$ = this.store.pipe(select(bookSelectors.getBooks));
  }

  booksExists(books: Book[]) {
    return books !== null && books.length > 0;
  }

  onBookClicked(book: Book) {
    this.router.navigate(['/books/', book.isbn]);
  }
}
