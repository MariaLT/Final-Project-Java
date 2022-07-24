import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StudentHomeComponent} from "./components/student-home/student-home.component";
import {LibrarianHomeComponent} from "./components/librarian-home/librarian-home.component";
import {AuthGuardService} from "./services/authentication/auth-guard.service";
import {UserLoginComponent} from "./components/user-login/user-login.component";
import {CatalogueComponent} from "./components/catalogue/catalogue.component";
import {BookDetailsComponent} from "./components/book-details/book-details.component";

const routes: Routes = [
  {
    path: 'user-login',
    component: UserLoginComponent
  },
  {
    path: 'student-home',
    canActivate: [AuthGuardService],
    component: StudentHomeComponent
  },
  {
    path: 'librarian-home',
    canActivate: [AuthGuardService],
    component: LibrarianHomeComponent
  },
  {
    path: 'catalogue',
    canActivate: [AuthGuardService],
    component: CatalogueComponent
  },
  {
    path: 'catalogue/:ean',
    canActivate: [AuthGuardService],
    component: BookDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
