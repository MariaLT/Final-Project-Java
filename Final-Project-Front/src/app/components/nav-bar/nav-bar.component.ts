import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/authentication/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  isLibrarian: boolean;
  isStudent : boolean;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {
    this.isLibrarian = false;
    this.isStudent = false;
  }

  ngOnInit(): void {
    if (this.authService.isLibrarian()) {
      this.isLibrarian = true;
    }else{
      this.isStudent = true;
    }
  }

  logout(): void {
    console.log('logging out...');
    this.authService.logout();

    this.router.navigate(['/login']);

  }

}
