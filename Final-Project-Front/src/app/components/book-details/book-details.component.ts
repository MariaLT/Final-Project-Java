import {Component, Input, OnInit} from '@angular/core';
import {Book} from "../../models/Book";
import {BooksService} from "../../services/library/books.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  book: Book;

  constructor(
    private bookService: BooksService,
    private activatedRoute: ActivatedRoute,
  ) {
    this.book = new Book(0, '', '', '', 0, '', 0,
      '', '', '');

  }

  ngOnInit(): void {
    let bookEan: number = this.activatedRoute.snapshot.params['ean'];
    console.log(bookEan);

    this.bookService.getBookByEan(bookEan).subscribe(
      bookBack => {
        console.log(bookBack);
        this.book = bookBack;
      });
  }


}
