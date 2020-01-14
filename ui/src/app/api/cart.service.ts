import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) {
  }

  addToCart(id: string, amount: string) {
    this.http.post('/v1/api/cart/add', {id: id, amount: amount}).subscribe(
      () => alert("Product added to cart!"),
      error => alert(error.error.message)
    );
  }

  getCartProducts() {
    this.http.get('/v1/api/cart/all').subscribe(
      response => console.log(response),
      error => console.log(error)
    );
  }
}
