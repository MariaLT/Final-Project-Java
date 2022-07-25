import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { LoanedBook } from 'src/app/models/LoanedBook';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LibrarianService {

  private readonly BASE_URL = 'http://localhost:8080/library/loanedBooks'

  constructor(private http: HttpClient) { }


  // Listado del estado de los libros

  getAvailableBooks() : Observable <LoanedBook[]> {
    return this.http.get <LoanedBook[]>(this.BASE_URL + '/available');
  }

  getLoanedBooks() : Observable <LoanedBook[]> {
    return this.http.get <LoanedBook[]>(this.BASE_URL + '/loaned');
  }

  getLostBooks() : Observable <LoanedBook[]> {
    return this.http.get <LoanedBook[]>(this.BASE_URL + '/lost');
  }

  getOverdueBooks() : Observable <LoanedBook[]> {
    return this.http.get <LoanedBook[]>(this.BASE_URL + '/overdue');
  }





}
