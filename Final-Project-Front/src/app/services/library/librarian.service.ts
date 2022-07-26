import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { LoanedBook } from 'src/app/models/LoanedBook';
import {Observable} from "rxjs";
import {User} from "../../models/User";

@Injectable({
  providedIn: 'root'
})
export class LibrarianService {

  private readonly BASE_URL = 'http://localhost:8080/library/loanedBooks'
  readonly API_URL = 'http://localhost:8080'

  constructor(private http: HttpClient) {
  }


  // Create a new loaned book

  createLoanedBook(ean: number): Observable<LoanedBook> {
    return this.http.post <LoanedBook>(this.BASE_URL + '/create', ean);
  }

  // All loaned books
  getAllLoanedBooks(): Observable<LoanedBook[]> {
    return this.http.get <LoanedBook[]>(this.BASE_URL);
  }

  // A single loaned book by ean
  getLoanedBook(ean: number): Observable<LoanedBook> {
    return this.http.get <LoanedBook>(this.BASE_URL + '/' + ean);
  }

  // Loaned book by Loan States

  getAvailableBooks(): Observable<LoanedBook[]> {
    return this.http.get <LoanedBook[]>(this.BASE_URL + '/available');
  }

  getLoanedBooks(): Observable<LoanedBook[]> {
    return this.http.get <LoanedBook[]>(this.BASE_URL + '/loaned');
  }

  getLostBooks(): Observable<LoanedBook[]> {
    return this.http.get <LoanedBook[]>(this.BASE_URL + '/lost');
  }

  getOverdueBooks(): Observable<LoanedBook[]> {
    return this.http.get <LoanedBook[]>(this.BASE_URL + '/overdue');
  }

  // User list
  getUsers(): Observable<User[]> {
    return this.http.get <User[]>(this.API_URL+'/users/list');
  }

  // Update overdue loaned books
  updateOverdueLoanedBooks(): Observable<LoanedBook[]> {
    return this.http.get <LoanedBook[]>(this.BASE_URL + '/update');
  }

}
