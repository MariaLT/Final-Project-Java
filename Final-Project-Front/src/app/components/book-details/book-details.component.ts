import {Component, OnInit} from '@angular/core';
import {Book} from "../../models/Book";
import {BooksService} from "../../services/library/books.service";
import {ActivatedRoute} from "@angular/router";
import {StudentService} from "../../services/library/student.service";
import {User} from "../../models/User";
import {LoanedDTO} from "../../models/LoanedDTO";
import {AuthService} from "../../services/authentication/auth.service";
import {LoanedBook} from "../../models/LoanedBook";
import {LOAN_STATE} from "../../models/LOAN_STATE";
import {PICKED_UP} from "../../models/PICKED_UP";
import {LibrarianService} from "../../services/library/librarian.service";

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
  isAvailable: boolean;
  isLoaned: boolean;

  loanedBook: LoanedBook;

  returnDate: Date;

  constructor(
    private bookService: BooksService,
    private studentService: StudentService,
    private activatedRoute: ActivatedRoute,
    private authService: AuthService,
    private librarianService: LibrarianService
  ) {
    this.book = new Book(0, '', '', '', 0, '', 0,
      '', '', '');

    this.bookEan = this.activatedRoute.snapshot.params['ean'];

    this.isLibrarian = false;
    this.isStudent = false;
    this.loanedBook = new LoanedBook(0, LOAN_STATE.AVAILABLE, new Date(),
      new Date(), PICKED_UP.NO, 0);

    this.isAvailable = true;
    this.isLoaned = false;
    this.returnDate = new Date();
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
        this.loanedBook = loanedBookBack;
        console.log('Book loaned')
        console.log(this.loanedBook);
      },
      error => alert('El libro ya esta prestado')
    );
    this.isLoaned = true;
    this.isAvailable = false;
  }

  /*dateReturnBook(): Date {
    let loanState: LOAN_STATE;
    this.librarianService.getLoanedBook(this.bookEan).subscribe(
      loanedBookBack => {
        this.returnDate = loanedBookBack.returnDate;

      }
    );
    if (loanState !=== LOAN_STATE.AVAILABLE){
    this.isLoaned = true;
    this.isAvailable = false;
    return this.returnDate;
  }
  }
*/

}

