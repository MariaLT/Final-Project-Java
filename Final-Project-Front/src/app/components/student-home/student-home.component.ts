import {Component, OnInit} from '@angular/core';
import {Book} from "../../models/Book";
import {StudentService} from "../../services/library/student.service";
import {LoanedBook} from "../../models/LoanedBook";
import {User} from "../../models/User";
import {BooksService} from "../../services/library/books.service";

@Component({
  selector: 'app-student-home',
  templateUrl: './student-home.component.html',
  styleUrls: ['./student-home.component.css']
})
export class StudentHomeComponent implements OnInit {

  loanedBooks: LoanedBook [];

  currentUser: User;

  isOverdueLoanedBook : boolean;

  book : Book;

  title: string;

  constructor(
    private studentService: StudentService,
    private bookService: BooksService
  ) {
    this.loanedBooks = [];
    this.currentUser = JSON.parse(localStorage.getItem("currentUser") as string);
    this.isOverdueLoanedBook = false;

    this.book = new Book(0, '', '', '', 0, '', 0,
      '', '', '');
    this.title = '';
  }


  ngOnInit(): void {
    this.showLoanedBooks();
    this.overdueBooks()
  }

  showLoanedBooks() {
    this.studentService.loanedBookFindByUserId(this.currentUser.id).subscribe(
      bookListBack => {
        this.loanedBooks = bookListBack;
      }
    );
    this.overdueBooks();
  }

  overdueBooks() {
    for (let loanedBook of this.loanedBooks) {
      if (loanedBook.loanState.includes("Overdue")) {
        alert("You have overdue books!");
        console.log("Overdue");
        this.isOverdueLoanedBook = true;
      }
    }
  }

  showTitle(ean: number): string {
    this.bookService.getBookByEan(ean).subscribe(
      bookBack => {
        this.book = bookBack;
      }
    );
    return this.book.title;
  }
}
