import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";
import {User} from "../../models/User";
import {AuthService} from "../../services/authentication/auth.service";
import {Role} from "../../models/Role";


@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  librarianRole: Role;
  studentRole: Role;
  hide = true;
  loginForm: FormGroup;
  usernameInput: FormControl;
  passwordInput: FormControl

  currentUser: User;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {
    this.usernameInput = new FormControl('', [Validators.required]);
    this.passwordInput = new FormControl('', [Validators.required]);
    this.loginForm = new FormGroup({
      username: this.usernameInput,
      password: this.passwordInput
    });
    this.librarianRole = new Role(null, 'LIBRARIAN');
    this.studentRole = new Role(null, 'STUDENT');

    this.currentUser = new User(null, '', '', new Array<Role>());
  }

  ngOnInit(): void {
  }

  login() {
    this.authService.login(this.loginForm.value.username, this.loginForm.value.password).subscribe(
      (user: User) => {
        console.log('Login successful');
        console.log(user);

        // Store user in local storage to keep user logged in between page refreshes
        localStorage.removeItem('currentUser');
        localStorage.setItem('currentUser', JSON.stringify(user));

        this.loginForm.reset()

        for (let role of user.roles) {
          if (role.name === 'LIBRARIAN') {
            console.log('Librarian logged in');
            this.router.navigate(['/librarian-home']);
          } else if (role.name === 'STUDENT') {
            console.log('Student logged in');
            this.router.navigate(['/student-home']);
          }

        }
      }
      , error => alert('Identificación errónea'));

  }



}

