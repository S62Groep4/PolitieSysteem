
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { AuthenticationService } from '../service/authentication.service';
import { UserLogin } from '../user-login';
import { Router } from '@angular/router';

@Component({
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  title = 'Loginseite';
  error : string;

  form = new FormGroup({
    email : new FormControl(),
    password : new FormControl()
  });

  constructor(private auth : AuthenticationService, private router : Router) {
  }

  ngOnInit() {

  }

  submitCredentials(){
    this.auth.login(this.form.get('email').value, this.form.get('password').value).subscribe(result => {
      localStorage.setItem('token', result.headers.get('Authorization'));
      this.router.navigate(['home']);
      console.log("Succes");
    }, err => {
      if (err.status === 401) {
        this.error = 'Username or password incorrect';
        console.log("Incorrect");
      } else {
        this.error = 'An unknown error occured';
        console.log("Error");
      }
    });
  }
}
