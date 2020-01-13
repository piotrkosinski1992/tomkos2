import {Injectable} from '@angular/core';
import {Subject} from "rxjs";
import {Product} from "../modules/product/product";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private subject = new Subject<Product[]>();

  constructor(private http: HttpClient) {
  }

  searchProductsByPhrase(phrase: string) {
    this.http.post('http://localhost:7777/api/product/like/' + phrase, null).subscribe(
      (products: Product[]) => this.subject.next(products)
    );
  }

  getProducts() {
    return this.subject.asObservable()
  }
}
