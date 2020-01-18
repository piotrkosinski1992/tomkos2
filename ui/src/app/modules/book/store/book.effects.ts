import {Injectable} from '@angular/core';
import {Actions, Effect, ofType} from '@ngrx/effects';
import {Observable, of} from 'rxjs';
import {Action} from '@ngrx/store';
import * as bookActions from './book.actions';
import {
  BookActionTypes,
  TryLoadBookDetails,
  TryLoadBooksByPhrase,
  TryLoadNewestBooks
} from './book.actions';
import {catchError, map, mergeMap} from 'rxjs/operators';
import {BookService} from '../../../api/book.service';
import {BookDetails} from '../book-details';
import {Book} from '../book';


@Injectable()
export class BookEffects {

  constructor(private actions$: Actions, private bookService: BookService) {
  }

  @Effect()
  loadBookDetails: Observable<Action> = this.actions$.pipe(ofType(BookActionTypes.TRY_LOAD_BOOK_DETAILS),
    mergeMap((actionInput: TryLoadBookDetails) => this.bookService.findBookDetails(actionInput.isbn).pipe(
      map((bookDetails: BookDetails) => new bookActions.LoadBookDetailsSuccess(bookDetails)),
      catchError(err => {
        console.log(err);
        return of(null);
      })
    )));

  @Effect()
  loadBooksByPhrase: Observable<Action> = this.actions$.pipe(ofType(BookActionTypes.TRY_LOAD_BOOKS_BY_PHRASE),
    mergeMap((actionInput: TryLoadBooksByPhrase) => this.bookService.findBooksByPhrase(actionInput.phrase).pipe(
      map((books: Book[]) => new bookActions.LoadBooksByPhraseSuccess(books)),
      catchError(err => {
        console.log(err);
        return of(null);
      })
    )));

  @Effect()
  loadNewestBooks: Observable<Action> = this.actions$.pipe(ofType(BookActionTypes.TRY_LOAD_NEWEST_BOOKS),
    mergeMap(() => this.bookService.findNewestBooks().pipe(
      map((books: Book[]) => new bookActions.LoadNewestBooksSuccess(books)),
      catchError(err => {
        console.log(err);
        return of(null);
      })
    )));
}
