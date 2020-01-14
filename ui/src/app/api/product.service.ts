import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject} from "rxjs";
import {Product} from "../modules/product/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private subject = new BehaviorSubject<Product[]>([]);

  constructor(private http: HttpClient) {
  }

  searchProductsByPhrase(phrase: string) {
    this.http.get<Product[]>('/v1/api/product/like/' + phrase).subscribe(
      (products: Product[]) => this.subject.next(products)
    );
  }

  getProducts() {
    return this.subject.asObservable()
  }
}
