import {Component, Input, OnInit} from '@angular/core';
import {Book} from "../../models/Book";
import {BooksService} from "../../services/library/books.service";
import {ActivatedRoute, Router} from "@angular/router";
import {StudentService} from "../../services/library/student.service";
import {User} from "../../models/User";
import {LoanedDTO} from "../../models/LoanedDTO";
import {AuthService} from "../../services/authentication/auth.service";
import {LoanedBook} from "../../models/LoanedBook";

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  book: Book;

  bookEan: number;

  isLibrarian: boolean;
  isStudent: boolean;

  loanedBook: LoanedBook;

  constructor(
    private bookService: BooksService,
    private studentService: StudentService,
    private activatedRoute: ActivatedRoute,
    private authService: AuthService
  ) {
    this.book = new Book(0, '', '', '', 0, '', 0,
      '', '', '');

    this.bookEan = this.activatedRoute.snapshot.params['ean'];

    this.isLibrarian = false;
    this.isStudent = false;
    this.loanedBook = new LoanedBook(0, 0, 'AVAILABLE', new Date(),
      new Date(), 'NO', 0);

  }

  ngOnInit(): void {

    this.bookService.getBookByEan(this.bookEan).subscribe(
      bookBack => {
        console.log(bookBack);
        this.book = bookBack;
      });

    if (this.authService.isLibrarian()) {
      this.isLibrarian = true;
    } else {
      this.isStudent = true;
    }
  }

  currentUser: User = JSON.parse(localStorage.getItem("currentUser") as string);


  loaningBook() {
    let loanedDTO = new LoanedDTO(this.bookEan, this.currentUser.id);
    console.log(loanedDTO);
    this.studentService.loanBook(loanedDTO).subscribe(
      loanedBookBack => {
        this.loanedBook= loanedBookBack;
        console.log('Book loaned')
        console.log(this.loanedBook);
      }
    );

  }


}

