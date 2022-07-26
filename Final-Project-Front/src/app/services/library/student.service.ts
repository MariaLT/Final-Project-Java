import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {LoanedDTO} from "../../models/LoanedDTO";
import {LoanedBook} from "../../models/LoanedBook";


@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private readonly BASE_URL = 'http://localhost:8080/library/loanedBooks';

  constructor(private http: HttpClient) { }

    loanBook(loanedDTO: LoanedDTO): Observable<LoanedBook> {
    return this.http.post<LoanedBook>(this.BASE_URL, loanedDTO);
  }

  returnBook(ean: number): Observable<LoanedBook> {
    return this.http.delete<LoanedBook>(`${this.BASE_URL}/${ean}`);
  }
  loanedBookFindByUserId(userId: number| null): Observable<LoanedBook[]> {
    return this.http.get<LoanedBook[]>(`${this.BASE_URL}/user/${userId}`);
  }

}
