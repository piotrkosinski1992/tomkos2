import {Component, OnInit} from '@angular/core';
import {Observable, Subscription} from 'rxjs';
import {BookService} from '../../../api/book.service';
import {Book} from '../book';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {

  books$: Observable<Book[]>;
  subscription: Subscription;
  phrase: string;

  constructor(private bookService: BookService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    /*    this.subscription = this.bookService.getBooks().subscribe((books: Book[]) => {
          this.books = books;
        });*/

    //this.route.queryParams.subscribe(params => this.phrase = params.phrase);
    this.phrase = this.route.snapshot.paramMap.get('phrase');
    this.books$ = this.bookService.searchBooksByPhrase(this.phrase);
    // TODO ZROBIC TO NA STORA I TYLE W TEMACIE
  }

  /*  ngOnDestroy() {
      this.subscription.unsubscribe();
    }*/

  booksExists(books: Book[]) {
    return books !== null && books.length > 0;
  }
}
