import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';

import {FormControl, FormGroup, Validators} from "@angular/forms";
import {BooksService} from "../../services/library/books.service";
import {LibrarianService} from "../../services/library/librarian.service";
import {LoanedBook} from "../../models/LoanedBook";
import {MatPaginator} from "@angular/material/paginator";
import {Book} from "../../models/Book";
import {User} from "../../models/User";


@Component({
  selector: 'app-librarian-home',
  templateUrl: './librarian-home.component.html',
  styleUrls: ['./librarian-home.component.css']
})
export class LibrarianHomeComponent implements OnInit {

  // Controls for close buttons and invisible divs

  goDelete: boolean;
  goCreateLoanedBookRegister: boolean;
  goFindSingleLoanedBook: boolean;
  isAllLoanedBook: boolean;
  isOverdueBook: boolean;
  isAvailableBook: boolean;
  isLoanedBook: boolean;
  isLostBook: boolean;
  counter: number;

  bookForm: FormGroup;

  eanToDeleteInput: FormControl;

  allLoanedBooks: LoanedBook[];
  singleLoanedBook: LoanedBook;
  overdueBooks: LoanedBook [];
  availableBooks: LoanedBook [];
  loanedBooks: LoanedBook[];
  lostBooks: LoanedBook[];

  userList : User[];

  book: Book;
  title: string;

  totalAvailableBooks: number;
  totalAllLoanedBooks:number;
  totalOverdueBooks: number;
  totalLoanedBooks: number;
  totalLostBooks: number;


  page: number = 1;

  constructor(
    private bookService: BooksService,
    private librarianService: LibrarianService,
  ) {

    // Controls for close buttons and invisible divs
    this.counter = 0;
    this.goDelete = false;
    this.goCreateLoanedBookRegister = false;
    this.goFindSingleLoanedBook = false;
    this.isAllLoanedBook = false;
    this.isOverdueBook = false;
    this.isAvailableBook = false;
    this.isLoanedBook = false;
    this.isLostBook = false;


    this.eanToDeleteInput = new FormControl('', Validators.required);

    this.bookForm = new FormGroup({
        ean: this.eanToDeleteInput
      }
    );
    this.allLoanedBooks = [];
    this.singleLoanedBook = new LoanedBook(0, 0, 'AVAILABLE', new Date(), new Date(), 0);
    this.overdueBooks = [];
    this.availableBooks = [];
    this.loanedBooks = [];
    this.lostBooks = [];

    this.userList = [];

    this.book = new Book(0, '', '', '', 0, '', 0,
      '', '', '');
    this.title = '';

    this.totalAvailableBooks = 0;
    this.totalAllLoanedBooks = 0;
    this.totalOverdueBooks = 0;
    this.totalLoanedBooks = 0;
    this.totalLostBooks = 0;


  }


  ngOnInit(): void {

  }

  openCreateLoanedBookRegister(): void {
    this.goCreateLoanedBookRegister = true;
  }

  openDeleteBook(): void {
    this.goDelete = true;
  }

  findSingleLoanedBook() {
    this.goFindSingleLoanedBook = true;
  }

  // Close buttons
  goBack(): void {
    if (this.goDelete === true) {
      this.goDelete = false;
    } else if (this.goCreateLoanedBookRegister === true) {
      this.goCreateLoanedBookRegister = false;
    } else if (this.goFindSingleLoanedBook === true) {
      this.goFindSingleLoanedBook = false;
    }
  }

  increaseCounter() {
    this.counter++;
  }

  // Delete book
  deleteBook() {
    const ean = this.bookForm.get("ean")?.value;
    console.log(ean);
    this.bookService.deleteBook(ean).subscribe()
    this.goDelete = false;

  }


  // Create loaned book
  createLoanedBookRegister(): void {
    this.librarianService.createLoanedBook(this.bookForm.get("ean")?.value).subscribe();
    this.bookForm.reset();
  }

  // Show a single book by ean

  showSingleBook(): void {
    this.librarianService.getLoanedBook(this.bookForm.get("ean")?.value).subscribe(
      loanedBookBack => {
        this.singleLoanedBook = loanedBookBack;
      }
    );

  }

  // Show all loaned books register
  showAllLoanedBooks(): void {
    if (this.counter % 2 === 0) {
      this.librarianService.getAllLoanedBooks().subscribe(
        bookListBack => {
          this.allLoanedBooks = bookListBack;
        });
      this.totalAllLoanedBooks = this.allLoanedBooks.length;
      this.isAllLoanedBook = true;
    } else {
      this.isAllLoanedBook = false;
    }
  }
  showAllLoanedBooksPag() {
    this.librarianService.getAllLoanedBooks().subscribe(
      bookListBack => {
        this.allLoanedBooks = bookListBack;
      });

  }

  // Show all loaned books register overdue
  showOverdueBooks(): void {
    if (this.counter % 2 === 0) {
      this.librarianService.getOverdueBooks().subscribe(
        bookListBack => {
          this.overdueBooks = bookListBack;
        });
      this.totalOverdueBooks = this.overdueBooks.length;
      this.isOverdueBook = true;
    } else {
      this.isOverdueBook = false;
    }
  }
  showOverdueBooksPag(){
    this.librarianService.getOverdueBooks().subscribe(
      bookListBack => {
        this.overdueBooks = bookListBack;
      });
  }

  // Show all loaned books register available
  showAvailableBooks(): void {
    if (this.counter % 2 === 0) {
      this.librarianService.getAvailableBooks().subscribe(
        bookListBack => {
          this.availableBooks = bookListBack;
        });
      this.totalAvailableBooks = this.availableBooks.length;
      this.isAvailableBook = true;
    } else {
      this.isAvailableBook = false;
    }
  }
  showAvailableBooksPag() {
    this.librarianService.getAvailableBooks().subscribe(
      bookListBack => {
        this.availableBooks = bookListBack;
      });
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
  showLoanedBooksPag(){
    this.librarianService.getLoanedBooks().subscribe(
      bookListBack => {
        this.loanedBooks = bookListBack;
      });
  }

  // Show all loaned books register lost
  showLostBooks(): void {
    if (this.counter % 2 === 0) {
      this.librarianService.getLostBooks().subscribe(
        bookListBack => {
          this.lostBooks = bookListBack;
        });
      // for (let book of this.lostBooks) {
      //   this.bookService.getBookByEan(book.ean).subscribe(
      //     bookBack => {
      //       console.log(bookBack);
      //       this.book = bookBack;
      //     });
      //   this.title= this.book.title;
      // }
      this.totalLostBooks = this.lostBooks.length;
      this.isLostBook = true;
    } else {
      this.isLostBook = false;
    }
  }
  showLostBooksPag(){
    this.librarianService.getLostBooks().subscribe(
      bookListBack => {
        this.lostBooks = bookListBack;
      });
  }

/*  showUsers() {
    this.librarianService.getUsers().subscribe(
      user => {
        this.userList.push(user);
      });
  }*/



}



