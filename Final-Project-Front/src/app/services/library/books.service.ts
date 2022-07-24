import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Book} from "../../models/Book";

@Injectable({
  providedIn: 'root'
})
export class BooksService {

  private readonly BASE_URL = 'http://localhost:8080/library/books';
  private readonly BASE_URL_PROXY_BOOKS = 'http://localhost:8081/books';

  constructor(private http:HttpClient) { }

  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.BASE_URL );
  }

  getBookByEan(ean: number): Observable<Book> {
    return this.http.get<Book>(`${this.BASE_URL}/${ean}`);
  }

  getBookByEanpROXY(ean: number): Observable<Book> {
    return this.http.get<Book>(`${this.BASE_URL_PROXY_BOOKS}/${ean}`);
  }
}
