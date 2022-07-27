import {Component, Input, OnInit} from '@angular/core';
import {LibrarianService} from "../../services/library/librarian.service";
import {PickedUpDTO} from "../../models/PickedUpDTO";
import {LoanedBook} from "../../models/LoanedBook";
import {LOAN_STATE} from "../../models/LOAN_STATE";
import {PICKED_UP} from "../../models/PICKED_UP";
import {Router} from "@angular/router";

@Component({
  selector: 'app-loaned-books',
  templateUrl: './loaned-books.component.html',
  styleUrls: ['./loaned-books.component.css']
})
export class LoanedBooksComponent implements OnInit {
  ngOnInit(): void {
  }

  /*
    @Input('loanedBookItem')
    loanedBook: LoanedBook;

    counter: number;
    loanedBooks: LoanedBook[];
    totalLoanedBooks: number;
    isLoanedBook: boolean;
    pickedUpDTO: PickedUpDTO;
    page: number = 1;

    constructor(
      private librarianService: LibrarianService,
      private router: Router
    ) {
      this.counter = 0;
      this.loanedBooks = [];
      this.totalLoanedBooks = 0;
      this.isLoanedBook = false;
      this.pickedUpDTO = new PickedUpDTO(0);
      new LoanedBook(0, LOAN_STATE.AVAILABLE, new Date(),
        new Date(), PICKED_UP.NO, 0);
      this.loanedBook = new LoanedBook(0, LOAN_STATE.AVAILABLE, new Date(),
        new Date(), PICKED_UP.NO, 0);

    }



    // Show all loaned books register loaned
    showLoanedBooks(): void {
      if (this.counter % 2 === 0) {
        this.librarianService.getLoanedBooks().subscribe(
          bookListBack => {
            this.loanedBooks = bookListBack;
          });
        this.totalLoanedBooks = this.loanedBooks.length;
        this.isLoanedBook = true;
      } else {
        this.isLoanedBook = false;
      }
    }

    // Update pickedUp Loaned Book
    updatePickUpLoanedBook(ean: number) {
      this.pickedUpDTO = new PickedUpDTO(ean);
      this.librarianService.updatePickedUpLoanedBook(ean, this.pickedUpDTO).subscribe();
      this.router.navigate(["/loaned-books"]);
    }


    showLoanedBooksPag() {
      this.librarianService.getLoanedBooks().subscribe(
        bookListBack => {
          this.loanedBooks = bookListBack;
        });
    }

    // Return book
    returnBook(ean: number) {
      this.librarianService.returnBook(ean).subscribe(
        bookBack => {
          this.loanedBooks.splice(this.loanedBooks.indexOf(bookBack), 1);
        }
      );
    }*/
}
