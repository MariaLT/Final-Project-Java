import {Component, OnInit} from '@angular/core';
import {Book} from "../../models/Book";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {BooksService} from "../../services/library/books.service";

@Component({
  selector: 'app-register-book',
  templateUrl: './register-book.component.html',
  styleUrls: ['./register-book.component.css']
})
export class RegisterBookComponent implements OnInit {


  book: Book;

  bookForm: FormGroup;
  eanInput: FormControl;
  titleInput : FormControl;
  authorInput: FormControl;
  genreInput:FormControl;
  pagNumberInput: FormControl;
  languageInput:FormControl;
  publicationYearInput: FormControl;
  publisherInput: FormControl;
  imageInput: FormControl;
  plotInput: FormControl;

  constructor(
    private bookService: BooksService
  ) {
    this.book = new Book(0, '', '', '', 0, '', 0,
      '', '', '');

    this.eanInput = new FormControl('', Validators.required);
    this.titleInput = new FormControl('', Validators.required);
    this.authorInput = new FormControl('', Validators.required);
    this.genreInput = new FormControl('', Validators.required);
    this.pagNumberInput = new FormControl('', Validators.required);
    this.languageInput = new FormControl('', Validators.required);
    this.publicationYearInput = new FormControl('', Validators.required);
    this.publisherInput = new FormControl('', Validators.required);
    this.imageInput = new FormControl('');
    this.plotInput = new FormControl('');

    this.bookForm = new FormGroup({
      ean: this.eanInput,
      title: this.titleInput,
      author: this.authorInput,
      genre: this.genreInput,
      pagNumber: this.pagNumberInput,
      language: this.languageInput,
      publicationYear: this.publicationYearInput,
      publisher: this.publisherInput,
      image: this.imageInput,
      plot: this.plotInput
    });
  }

  ngOnInit(): void {
  }


  createBookRegister() {
    this.bookService.createBook(this.book).subscribe(
      bookBack => {
        this.book = bookBack;
      }
    );
  }


}
