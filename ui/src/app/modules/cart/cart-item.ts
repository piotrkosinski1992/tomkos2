import {Book} from '../book/book';

export interface CartItem {
  book: Book;
  amount: number;
}
