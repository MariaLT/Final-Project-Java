import {Component, OnInit} from '@angular/core';
import {Book} from "../../models/Book";
import {StudentService} from "../../services/library/student.service";
import {LoanedBook} from "../../models/LoanedBook";
import {User} from "../../models/User";

@Component({
  selector: 'app-student-home',
  templateUrl: './student-home.component.html',
  styleUrls: ['./student-home.component.css']
})
export class StudentHomeComponent implements OnInit {

  loanedBooks: LoanedBook [];

  currentUser: User;

  isOverdueLoanedBook : boolean;

  constructor(
    private studentService: StudentService
  ) {
    this.loanedBooks = [];
    this.currentUser = JSON.parse(localStorage.getItem("currentUser") as string);
    this.isOverdueLoanedBook = false;
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

  returnBook(ean: number) {
    this.studentService.returnBook(ean).subscribe(
      bookBack => {
        this.loanedBooks.splice(this.loanedBooks.indexOf(bookBack), 1);
      }
    );
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
}
