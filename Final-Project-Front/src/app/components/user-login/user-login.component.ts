import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';


@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  hide = true;

  userForm: FormGroup;
  emailInput: FormControl;
  passwordInput: FormControl;

  constructor() {
    this.emailInput = new FormControl('', [Validators.required, Validators.email]);
    this.passwordInput = new FormControl('', [Validators.required]);

    this.userForm = new FormGroup({
      email: this.emailInput,
      password: this.passwordInput
    });
  }

  ngOnInit(): void {
  }


}
