import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../../api/auth.service';
import {Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {BookState} from '../../book/store/book.reducers';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router, private store: Store<BookState>) {
  }

  ngOnInit() {
  }

  onLogout() {
    this.authService.logout();
  }

  onSearchClick(phrase: string) {
    this.router.navigate(['/books/search/', phrase]);
  }

  isInputEmpty(value: string) {
    return value.length === 0;
  }
}
