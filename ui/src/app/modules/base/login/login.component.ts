import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../../api/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  loading = false;

  constructor(private formBuilder: FormBuilder, private router: Router, private authService: AuthService) {
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['user', Validators.required],
      password: ['user', Validators.required]
    });
  }

  get fields() {
    return this.loginForm.controls;
  }

  onSubmit() {
    this.loading = true;
    this.authService.login(this.fields.username.value, this.fields.password.value)
    .subscribe(
      (authResponse: any) => {
        localStorage.setItem('token', authResponse.token);
        this.router.navigate(['/products']);
        this.loading = false;
      },
      error => {
        this.loading = false;
      });
  }
}
