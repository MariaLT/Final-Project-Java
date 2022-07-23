import {Component, OnInit} from '@angular/core';
import {Book} from "src/app/models/Book";
import {BooksService} from "../../services/library/books.service";

@Component({
  selector: 'app-catalogue',
  templateUrl: './catalogue.component.html',
  styleUrls: ['./catalogue.component.css']
})
export class CatalogueComponent implements OnInit {


  bookList: Book[] = [];

  constructor(private bookService: BooksService) {

  }

  ngOnInit(): void {
    this.getAllBooks();
  }

  getAllBooks() {
    this.bookService.getAllBooks().subscribe(
      bookListBack => {
        this.bookList = bookListBack;
      }
    );
  }
}
