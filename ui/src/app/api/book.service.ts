import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject} from 'rxjs';
import {Book} from '../modules/book/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private subject = new BehaviorSubject<Book[]>([]);

  constructor(private http: HttpClient) {
  }

  searchBooksByPhrase(phrase: string) {
    return this.http.get<Book[]>('/v1/api/book/like/' + phrase);
  }

  getBooks() {
    return this.subject.asObservable();
  }
}
