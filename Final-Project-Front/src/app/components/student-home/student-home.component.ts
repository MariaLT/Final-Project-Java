import { Component, OnInit } from '@angular/core';
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

  loanedBooks : LoanedBook [];

  currentUser : User;

  constructor(
    private studentService: StudentService
  ) {
    this.loanedBooks = [];
    this.currentUser= JSON.parse(localStorage.getItem("currentUser") as string);
  }



  ngOnInit(): void {
    this.studentService.loanedBookFindByUserId(this.currentUser.id).subscribe(
      bookListBack => {
        this.loanedBooks = bookListBack;
      }
    );
  }

}
