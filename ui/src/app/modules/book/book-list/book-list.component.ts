import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from 'rxjs';
import {BookService} from '../../../api/book.service';
import {Book} from '../book';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit, OnDestroy {

  books: Book[];
  subscription: Subscription;

  constructor(private bookService: BookService) {
  }

  ngOnInit() {
    this.subscription = this.bookService.getBooks().subscribe((books: Book[]) => {
      this.books = books;
    });
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  booksExists() {
    return this.books.length > 0;
  }
}
