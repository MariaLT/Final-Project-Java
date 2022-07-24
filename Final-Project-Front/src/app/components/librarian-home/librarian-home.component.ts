import {Component, OnInit} from '@angular/core';
import {Book} from "../../models/Book";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {BooksService} from "../../services/library/books.service";

@Component({
  selector: 'app-librarian-home',
  templateUrl: './librarian-home.component.html',
  styleUrls: ['./librarian-home.component.css']
})
export class LibrarianHomeComponent implements OnInit {

  goDelete: boolean = false;
  isDeleted: boolean = false;

  bookForm: FormGroup;

  eanToDeleteInput: FormControl;

  constructor(private bookService: BooksService) {

    this.eanToDeleteInput = new FormControl('', Validators.required);

    this.bookForm = new FormGroup({
        ean: this.eanToDeleteInput
      }
    );
  }


  ngOnInit(): void {
  }

  openDeleteBook(): void {
    this.goDelete = true;
  }

  goBack(): void {
    this.goDelete = false;
  }
/*this.bookForm.get("ean")?.value,*/
  onSubmit() {
    const ean = this.bookForm.get("ean")?.value;
    console.log(ean);
    this.bookService.deleteBook(ean).subscribe();

    this.goDelete = false;
    this.isDeleted = true;
  }


}
