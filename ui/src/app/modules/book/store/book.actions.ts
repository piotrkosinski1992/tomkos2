import {Action} from '@ngrx/store';
import {Book} from '../book';
import {BookDetails} from '../book-details';

export enum BookActionTypes {
  TRY_LOAD_BOOKS_BY_PHRASE = '[book] try load books by phrase',
  LOAD_BOOKS_BY_PHRASE_SUCCESS = '[book] load books success',
  LOAD_BOOKS_BY_PHRASE_FAILED = '[book] load books by phrase failed',

  TRY_LOAD_BOOK_DETAILS = '[book] try load book details',
  LOAD_BOOK_DETAILS_SUCCESS = '[book] load book details success',
  LOAD_BOOK_DETAILS_FAILED = '[book] load book details failed',

  TRY_LOAD_NEWEST_BOOKS = '[book] try load newest books',
  LOAD_NEWEST_BOOKS_SUCCESS = '[book] load newest books success',
  LOAD_NEWEST_BOOKS_FAILED = '[book] load newest books failed',
}

export class TryLoadBooksByPhrase implements Action {
  readonly type = BookActionTypes.TRY_LOAD_BOOKS_BY_PHRASE;

  constructor(public phrase: string) {
  }
}

export class LoadBooksByPhraseSuccess implements Action {
  readonly type = BookActionTypes.LOAD_BOOKS_BY_PHRASE_SUCCESS;

  constructor(public books: Book[]) {
  }
}

export class TryLoadBookDetails implements Action {
  readonly type = BookActionTypes.TRY_LOAD_BOOK_DETAILS;

  constructor(public isbn: string) {
  }
}

export class LoadBookDetailsSuccess implements Action {
  readonly type = BookActionTypes.LOAD_BOOK_DETAILS_SUCCESS;

  constructor(public bookDetails: BookDetails) {
  }
}

export class TryLoadNewestBooks {
  readonly type = BookActionTypes.TRY_LOAD_NEWEST_BOOKS;

  constructor() {
  }
}

export class LoadNewestBooksSuccess {
  readonly type = BookActionTypes.LOAD_NEWEST_BOOKS_SUCCESS;

  constructor(public books: Book[]) {
  }
}

export type BookActions =
  TryLoadBooksByPhrase |
  LoadBooksByPhraseSuccess |
  TryLoadBookDetails |
  LoadBookDetailsSuccess |
  TryLoadNewestBooks |
  LoadNewestBooksSuccess;
