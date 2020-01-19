import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Book} from '../modules/book/book';
import {BookDetails} from '../modules/book/book-details';
import {Observable} from 'rxjs';
import {Category} from '../modules/book/book-list/book-categories/category';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) {
  }

  findBooksByPhrase(phrase: string) {
    return this.http.get<Book[]>('/v1/api/book/like/' + phrase);
  }

  findBookDetails(isbn: string) {
    return this.http.get<BookDetails>('/v1/api/book/isbn/' + isbn);
  }

  findNewestBooks() {
    return this.http.get<Book[]>('/v1/api/book/newest');
  }

  fetchCategories(): Observable<Category[]> {
    return this.http.get<Category[]>('/v1/api/book/categories');
  }
}
