import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) {
  }

  addToCart(isbn: string, amount: string) {
    return this.http.post('/v1/api/cart/add', {isbn: isbn, amount: amount});
  }

  getCart() {
    return this.http.get('/v1/api/cart/all');
  }

  removeByIsbn(isbn: string) {
    return this.http.delete('/v1/api/cart/' + isbn);
  }
}
