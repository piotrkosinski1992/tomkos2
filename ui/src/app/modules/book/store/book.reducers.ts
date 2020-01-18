import {BookActions, BookActionTypes} from './book.actions';
import {BookDetails} from '../book-details';
import {Book} from '../book';

export interface BookState {
  bookDetails: BookDetails;
  books: Book[];
}

export const bookInitState: BookState = {
  bookDetails: undefined,
  books: []
};

export function bookReducers(state = bookInitState, action: BookActions) {
  switch (action.type) {
    case BookActionTypes.LOAD_BOOK_DETAILS_SUCCESS: {
      return {
        ...state,
        bookDetails: action.bookDetails
      };
    }
    case BookActionTypes.LOAD_BOOKS_BY_PHRASE_SUCCESS: {
      return {
        ...state,
        books: action.books
      };
    }
    case BookActionTypes.LOAD_NEWEST_BOOKS_SUCCESS: {
      return {
        ...state,
        books: action.books
      };
    }
    default:
      return {
        ...state
      };
  }
}
