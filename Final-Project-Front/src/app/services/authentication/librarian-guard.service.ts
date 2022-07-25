import { Injectable } from '@angular/core';
import {AuthService} from "./auth.service";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class LibrarianGuardService {

  constructor(
    public auth: AuthService,
    public router: Router

  ) { }

  canActivate(): boolean {
    if (!this.auth.isLibrarian()) {
      this.router.navigate(['librarian-home']);
      return false;
    }
    return true;
  }
}
