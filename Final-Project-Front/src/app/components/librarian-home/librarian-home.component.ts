import {Component, OnInit} from '@angular/core';

import {FormControl, FormGroup, Validators} from "@angular/forms";
import {BooksService} from "../../services/library/books.service";
import {LibrarianService} from "../../services/library/librarian.service";
import {LoanedBook} from "../../models/LoanedBook";
import {Book} from "../../models/Book";
import {User} from "../../models/User";
import {PickedUpDTO} from "../../models/PickedUpDTO";
import {LOAN_STATE} from "../../models/LOAN_STATE";
import {LoanStateDTO} from "../../models/LoanStateDTO";
import {Router} from "@angular/router";


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
  showBook: boolean;
  isAllLoanedBook: boolean;
  isOverdueBook: boolean;
  isAvailableBook: boolean;
  isLoanedBook: boolean;
  isLostBook: boolean;
  isShowUser: boolean;
  goChangeStatus: boolean;
  counter1: number;
  counter2: number;
  counter3: number;
  counter4: number;
  counter5: number;
  counter6: number;

  bookForm: FormGroup;

  eanToDeleteInput: FormControl;

  allLoanedBooks: LoanedBook[];
  singleLoanedBook: LoanedBook [];
  overdueBooks: LoanedBook [];
  availableBooks: LoanedBook [];
  loanedBooks: LoanedBook[];
  lostBooks: LoanedBook[];

  userList: User[];

  book: Book;
  title: string;

  totalAvailableBooks: number;
  totalAllLoanedBooks: number;
  totalOverdueBooks: number;
  totalLoanedBooks: number;
  totalLostBooks: number;


  page: number = 1;

  pickedUpDTO: PickedUpDTO;

  constructor(
    private bookService: BooksService,
    private librarianService: LibrarianService,
    private router: Router
  ) {

    // Controls for close buttons and invisible divs
    this.counter1 = 0;
    this.counter2 = 0;
    this.counter3 = 0;
    this.counter4 = 0;
    this.counter5 = 0;
    this.counter6 = 0;

    this.goDelete = false;
    this.goCreateLoanedBookRegister = false;
    this.goFindSingleLoanedBook = false;
    this.showBook = false;
    this.isAllLoanedBook = false;
    this.isOverdueBook = false;
    this.isAvailableBook = false;
    this.isLoanedBook = false;
    this.isLostBook = false;
    this.isShowUser = false;
    this.goChangeStatus = false;


    this.eanToDeleteInput = new FormControl('', Validators.required);

    this.bookForm = new FormGroup({
        ean: this.eanToDeleteInput
      }
    );
    this.allLoanedBooks = [];
    this.singleLoanedBook = []
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


    this.pickedUpDTO = new PickedUpDTO(0);
  }


  ngOnInit(): void {
    this.librarianService.updateOverdueLoanedBooks().subscribe();
  }

  // Open buttons
  openCreateLoanedBookRegister(): void {
    this.goCreateLoanedBookRegister = true;
  }

  openDeleteBook(): void {
    this.goDelete = true;
  }

  findSingleLoanedBook() {
    this.goFindSingleLoanedBook = true;
  }

  changeOneStatus() {
    this.goChangeStatus = true;
  }

  // Close buttons
  goBack(): void {
    if (this.goDelete === true) {
      this.goDelete = false;
    } else if (this.goCreateLoanedBookRegister === true) {
      this.goCreateLoanedBookRegister = false;
    } else if (this.goFindSingleLoanedBook === true) {
      this.goFindSingleLoanedBook = false;
    } else if (this.goChangeStatus === true) {
      this.goChangeStatus = false;
    }
  }

  // Delete book
  deleteBook() {
    const ean = this.bookForm.get("ean")?.value;
    console.log(ean);
    this.bookService.deleteBook(ean).subscribe()
    this.goDelete = false;

  }


  /*  // Create loaned book
    createLoanedBookRegister(): void {
      this.librarianService.createLoanedBook(this.bookForm.get("ean")?.value).subscribe();
      this.bookForm.reset();
    }*/

  // Show a single book by ean

  showSingleBook() {
    this.singleLoanedBook = [];
    this.librarianService.getLoanedBook(this.bookForm.get("ean")?.value).subscribe(
      loanedBookBack => {
        this.singleLoanedBook.push(loanedBookBack);
      }
    );
    this.showBook = true;

  }

  // Show all loaned books register
  showAllLoanedBooks(): void {
    if (this.counter1 % 2 === 0) {
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

  increaseCounter1() {
    this.counter1++;
  }

  showAllLoanedBooksPag() {
    this.librarianService.getAllLoanedBooks().subscribe(
      bookListBack => {
        this.allLoanedBooks = bookListBack;
      });
  }

  // Show all loaned books register overdue
  showOverdueBooks(): void {
    if (this.counter2 % 2 === 0) {
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

  increaseCounter2() {
    this.counter2++;
  }

  showOverdueBooksPag() {
    this.librarianService.getOverdueBooks().subscribe(
      bookListBack => {
        this.overdueBooks = bookListBack;
      });
  }

  // Show all loaned books register available
  showAvailableBooks(): void {
    if (this.counter3 % 2 === 0) {
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

  increaseCounter3() {
    this.counter3++;
  }

  showAvailableBooksPag() {
    this.librarianService.getAvailableBooks().subscribe(
      bookListBack => {
        this.availableBooks = bookListBack;
      });
  }


  // Show all loaned books register lost
  showLostBooks(): void {
    if (this.counter4 % 2 === 0) {
      this.librarianService.getLostBooks().subscribe(
        bookListBack => {
          this.lostBooks = bookListBack;
        });
      this.totalLostBooks = this.lostBooks.length;
      this.isLostBook = true;
    } else {
      this.isLostBook = false;
    }
  }

  increaseCounter4() {
    this.counter4++;
  }

  showLostBooksPag() {
    this.librarianService.getLostBooks().subscribe(
      bookListBack => {
        this.lostBooks = bookListBack;
      });
  }

  showUsers() {
    if (this.counter5 % 2 === 0) {
      this.librarianService.getUsers().subscribe(
        userListBack => {
          this.userList = userListBack;
        }
      );
      this.isShowUser = true;
    } else {
      this.isShowUser = false;
    }
  }

  increaseCounter5() {
    this.counter5++;
  }

  changeStatus() {
    const ean = this.bookForm.get("ean")?.value;
    let loanStatus = new LoanStateDTO(LOAN_STATE.LOST);
    this.librarianService.updateLoanedBook(ean, loanStatus).subscribe();
    this.goChangeStatus = true;
    this.bookForm.reset();
  }

  // Return book
  returnBook(ean: number) {
    this.librarianService.returnBook(ean).subscribe();
    this.isLoanedBook = false;
    this.isOverdueBook = false;
    this.counter6++;
    alert('Libro devuelto')
  }

  showLoanedBooks(): void {
    if (this.counter6 % 2 === 0) {
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

  increaseCounter6() {
    this.counter6++;
  }


  // Update pickedUp Loaned Book
  updatePickUpLoanedBook(ean: number) {
    this.pickedUpDTO = new PickedUpDTO(ean);
    this.librarianService.updatePickedUpLoanedBook(ean, this.pickedUpDTO).subscribe();
/*    this.librarianService.getLoanedBooks().subscribe(
      bookListBack => {
        this.loanedBooks = bookListBack;
      });
    this.totalLoanedBooks = this.loanedBooks.length;*/
    this.isLoanedBook = true;
    this.isLoanedBook = false;
    this.counter6++;
  }


  refresh(): void {
    this.librarianService.getLoanedBooks().subscribe(
    bookListBack => {
      this.loanedBooks = bookListBack;
    });
    this.totalLoanedBooks = this.loanedBooks.length;
    this.isLoanedBook = true; }


  showLoanedBooksPag() {
    this.librarianService.getLoanedBooks().subscribe(
      bookListBack => {
        this.loanedBooks = bookListBack;
      });
  }
}

