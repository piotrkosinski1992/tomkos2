import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../api/auth.service";
import {ProductService} from "../../../api/product.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(private authService: AuthService, private productService: ProductService) {
  }

  ngOnInit() {
  }

  onLogout() {
    this.authService.logout()
  }

  onSearchClick(phrase: string) {
    this.productService.searchProductsByPhrase(phrase)
  }

  isInputEmpty(value: string) {
    return value.length == 0
  }
}
