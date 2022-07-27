import {Component, OnInit} from '@angular/core';
import {Book} from "../../models/Book";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {BooksService} from "../../services/library/books.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register-book',
  templateUrl: './register-book.component.html',
  styleUrls: ['./register-book.component.css']
})
export class RegisterBookComponent implements OnInit {


  book: Book;

  bookForm: FormGroup;
  eanInput: FormControl;
  titleInput: FormControl;
  authorInput: FormControl;
  genreInput: FormControl;
  pagNumberInput: FormControl;
  languageInput: FormControl;
  publicationYearInput: FormControl;
  publisherInput: FormControl;
  imageInput: FormControl;
  plotInput: FormControl;

  constructor(
    private bookService: BooksService,
    private router: Router
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

  onSubmit() {
    console.log('Book submitted');
    const book: Book = new Book(
      this.bookForm.get("ean")?.value,
      this.bookForm.get("title")?.value,
      this.bookForm.get("author")?.value,
      this.bookForm.get("genre")?.value,
      this.bookForm.get("pagNumber")?.value,
      this.bookForm.get("language")?.value,
      this.bookForm.get("publicationYear")?.value,
      this.bookForm.get("publisher")?.value,
      this.bookForm.get("image")?.value,
      this.bookForm.get("plot")?.value);
    console.log(book);
    this.bookService.createBook(book).subscribe(
      data => {
        console.log(data);
      }
    );
    alert('Book register created');
    this.router.navigate(['/librarian-home']);
  }

}
