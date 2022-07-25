import { Injectable } from '@angular/core';
import {AuthService} from "./auth.service";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class StudentGuardService {

  constructor(
    public auth: AuthService,
    public router: Router

  ) { }

  canActivate(): boolean {
    if (!this.auth.isStudent()) {
      this.router.navigate(['student-home']);
      return false;
    }
    return true;
  }

}
