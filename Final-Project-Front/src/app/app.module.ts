import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';


import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {StudentHomeComponent} from './components/student-home/student-home.component';
import {LibrarianHomeComponent} from './components/librarian-home/librarian-home.component';
import {NavBarComponent} from './components/nav-bar/nav-bar.component';
import {UserLoginComponent} from './components/user-login/user-login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";
import {MatCardModule} from "@angular/material/card";
import {HttpClientModule} from "@angular/common/http";
import {MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import { CatalogueComponent } from './components/catalogue/catalogue.component';
import { FooterComponent } from './components/footer/footer.component';
import { BookDetailsComponent } from './components/book-details/book-details.component';
import { RegisterBookComponent } from './components/register-book/register-book.component';
import { HeaderComponent } from './components/header/header.component';
import {MatPaginatorModule} from "@angular/material/paginator";
import { NgxPaginationModule } from 'ngx-pagination';


@NgModule({
  declarations: [
    AppComponent,
    StudentHomeComponent,
    LibrarianHomeComponent,
    NavBarComponent,
    UserLoginComponent,
    CatalogueComponent,
    FooterComponent,
    BookDetailsComponent,
    RegisterBookComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatIconModule,
    MatCardModule,
    MatButtonModule,
    MatInputModule,
    MatPaginatorModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
