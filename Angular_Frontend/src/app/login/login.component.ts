
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';

@Component({
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  title = 'Loginseite';

  form = new FormGroup({
    email : new FormControl(),
    password : new FormControl()
  });

  constructor() {
  }

  ngOnInit() {

  }
}
