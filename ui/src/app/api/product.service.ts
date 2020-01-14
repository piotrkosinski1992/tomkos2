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
    this.http.get('http://localhost:7777/api/product/like/' + phrase).subscribe(
      (products: Product[]) => this.subject.next(products)
    );
  }

  getProducts() {
    return this.subject.asObservable()
  }
}
