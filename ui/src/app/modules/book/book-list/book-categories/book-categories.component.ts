import {Component, OnInit} from '@angular/core';
import {BookService} from '../../../../api/book.service';
import {Observable} from 'rxjs';
import {Category} from './category';

@Component({
  selector: 'app-book-categories',
  templateUrl: './book-categories.component.html',
  styleUrls: ['./book-categories.component.scss']
})
export class BookCategoriesComponent implements OnInit {

  categories$: Observable<Category[]>;

  constructor(private bookService: BookService) {
  }

  ngOnInit() {
    this.categories$ = this.bookService.fetchCategories();
  }
}
