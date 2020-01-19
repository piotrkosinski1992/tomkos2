import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../../api/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) {
  }

  ngOnInit() {
  }

  onLogout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

  onSearchClick(phrase: string) {
    this.router.navigate(['/books/search/', phrase]);
  }

  isInputEmpty(value: string) {
    return value.length === 0;
  }
}
