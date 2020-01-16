import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) {
  }

  addToCart(isbn: string, amount: string) {
    this.http.post('/v1/api/cart/add', {isbn: isbn, amount: amount}).subscribe(
      () => alert('Book added to cart!'),
      error => alert(error.error.message)
    );
  }

  getCartBooks() {
    return this.http.get('/v1/api/cart/all');
  }

  deleteByIsbn(isbn: string) {
    this.http.delete('/v1/api/cart/' + isbn).subscribe();
  }
}
