import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Book} from "../../models/Book";

@Injectable({
  providedIn: 'root'
})
export class BooksService {

  private readonly BASE_URL = 'http://localhost:8080/library/books';

  constructor(private http:HttpClient) { }

  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.BASE_URL );
  }
}
