import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../../api/auth.service';
import {BookService} from '../../../api/book.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(private authService: AuthService, private bookService: BookService) {
  }

  ngOnInit() {
  }

  onLogout() {
    this.authService.logout();
  }

  onSearchClick(phrase: string) {
    this.bookService.searchBooksByPhrase(phrase);
  }

  isInputEmpty(value: string) {
    return value.length === 0;
  }
}
