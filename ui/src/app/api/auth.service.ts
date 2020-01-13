import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    return this.http.post('/v1/api/user/auth', {username: username, password: password})
  }

  isLoggedIn() {
    return localStorage.getItem('token')
  }

  logout() {
    localStorage.clear()
  }

  getToken() {
    return localStorage.getItem('token');
  }
}
