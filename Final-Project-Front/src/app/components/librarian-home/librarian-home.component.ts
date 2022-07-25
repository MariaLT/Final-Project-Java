import {Component, OnInit} from '@angular/core';
import {Book} from "../../models/Book";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {BooksService} from "../../services/library/books.service";
import {LibrarianService} from "../../services/library/librarian.service";
import {LoanedBook} from "../../models/LoanedBook";

@Component({
  selector: 'app-librarian-home',
  templateUrl: './librarian-home.component.html',
  styleUrls: ['./librarian-home.component.css']
})
export class LibrarianHomeComponent implements OnInit {
  listOverdueBooks:boolean = false;
  goDelete: boolean = false;
  isDeleted: boolean = false;

  bookForm: FormGroup;

  eanToDeleteInput: FormControl;

  overdueBooks : LoanedBook [];
  availableBooks : LoanedBook [];

  constructor(
    private bookService: BooksService,
  private librarianService: LibrarianService,
  ) {

    this.eanToDeleteInput = new FormControl('', Validators.required);

    this.bookForm = new FormGroup({
        ean: this.eanToDeleteInput
      }
    );

    this.overdueBooks = [];
    this.availableBooks = [];
  }


  ngOnInit(): void {
  }

  openDeleteBook(): void {
    this.goDelete = true;
  }

  goBack(): void {
    this.goDelete = false;
  }

  onSubmit() {
    const ean = this.bookForm.get("ean")?.value;
    console.log(ean);
    this.bookService.deleteBook(ean).subscribe();

    this.goDelete = false;
    this.isDeleted = true;
  }

  showOverdueBooks(): void {
    this.librarianService.getOverdueBooks().subscribe(
       bookListBack => {
          this.overdueBooks = bookListBack;
       });
    this.listOverdueBooks = true;
  }

  showAvailableBooks(): void {
    this.librarianService.getAvailableBooks().subscribe(
       bookListBack => {
          this.availableBooks = bookListBack;
       });
  }
/*  getAllBooks() {
    this.bookService.getAllBooks().subscribe(
      bookListBack => {
        this.bookList = bookListBack;
      }
    );
  }*/
}
