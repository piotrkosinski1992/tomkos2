import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject} from 'rxjs';
import {Book} from '../modules/book/book';
import {BookDetails} from '../modules/book/book-details';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private subject = new BehaviorSubject<Book[]>([]);

  constructor(private http: HttpClient) {
  }

  searchBooksByPhrase(phrase: string) {
    this.http.get<BookDetails[]>('/v1/api/book/like/' + phrase).subscribe(
      (books: BookDetails[]) => this.subject.next(books)
    );
  }

  getBooks() {
    return this.subject.asObservable();
  }
}
