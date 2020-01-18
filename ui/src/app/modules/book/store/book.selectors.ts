import {BookState} from './book.reducers';
import {createFeatureSelector, createSelector} from '@ngrx/store';

export const bookFeature = 'book';

const getBookFeatureState = createFeatureSelector<BookState>(bookFeature);

export const getBookDetails = createSelector(
  getBookFeatureState,
  (state: BookState) => state.bookDetails
);

export const getBooks = createSelector(
  getBookFeatureState,
  (state: BookState) => state.books
);
