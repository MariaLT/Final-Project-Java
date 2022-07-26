import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StudentHomeComponent} from "./components/student-home/student-home.component";
import {LibrarianHomeComponent} from "./components/librarian-home/librarian-home.component";
import {AuthGuardService} from "./services/authentication/auth-guard.service";
import {UserLoginComponent} from "./components/user-login/user-login.component";
import {CatalogueComponent} from "./components/catalogue/catalogue.component";
import {BookDetailsComponent} from "./components/book-details/book-details.component";
import {RegisterBookComponent} from "./components/register-book/register-book.component";
import {LibrarianGuardService} from "./services/authentication/librarian-guard.service";
import {StudentGuardService} from "./services/authentication/student-guard.service";
import {LoanedBooksComponent} from "./components/loaned-books/loaned-books.component";

const routes: Routes = [
  {
    path: '',
    component: UserLoginComponent
  },
  {
    path: 'user-login',
    component: UserLoginComponent
  },
  {
    path: 'student-home',
    canActivate: [StudentGuardService],
    component: StudentHomeComponent
  },
  {
    path: 'librarian-home',
    canActivate: [LibrarianGuardService],
    component: LibrarianHomeComponent
  },
  {
    path: 'loaned-books',
    canActivate: [LibrarianGuardService],
    component: LoanedBooksComponent
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
  },
  {
    path: 'register-book',
    canActivate: [AuthGuardService],
    component: RegisterBookComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
