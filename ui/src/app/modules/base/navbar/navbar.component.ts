import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../../api/auth.service';
import {BookService} from '../../../api/book.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(private authService: AuthService, private bookService: BookService, private router: Router) {
  }

  ngOnInit() {
  }

  onLogout() {
    this.authService.logout();
  }

  onSearchClick(searchString: string) {
    this.router.navigate(['/books/search/', searchString], );
    // this.bookService.searchBooksByPhrase(searchString);
  }

  isInputEmpty(value: string) {
    return value.length === 0;
  }
}
