import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Book} from '../modules/book/book';
import {BookDetails} from '../modules/book/book-details';

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
}
