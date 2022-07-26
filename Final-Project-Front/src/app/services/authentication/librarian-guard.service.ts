import { Injectable } from '@angular/core';
import {AuthService} from "./auth.service";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {User} from "../../models/User";

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
