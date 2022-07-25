import {Component, Input, OnInit} from '@angular/core';
import {Book} from "../../models/Book";
import {BooksService} from "../../services/library/books.service";
import {ActivatedRoute, Router} from "@angular/router";
import {StudentService} from "../../services/library/student.service";
import {User} from "../../models/User";
import {LoanedDTO} from "../../models/LoanedDTO";

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  book: Book;

  bookEan: number;

  constructor(
    private bookService: BooksService,
    private studentService: StudentService,
    private activatedRoute: ActivatedRoute,
  ) {
    this.book = new Book(0, '', '', '', 0, '', 0,
      '', '', '');

    this.bookEan = this.activatedRoute.snapshot.params['ean'];

  }

  ngOnInit(): void {

    this.bookService.getBookByEan(this.bookEan).subscribe(
      bookBack => {
        console.log(bookBack);
        this.book = bookBack;
      });
  }

  currentUser : User = JSON.parse(localStorage.getItem("currentUser") as string);


  loaningBook() {
    let loanedDTO = new LoanedDTO(this.bookEan, this.currentUser.id);

/*    this.studentService.loanBook(this.bookEan).subscribe(
      () => {
        console.log('Book loaned');
      }
    );*/

  }


}

