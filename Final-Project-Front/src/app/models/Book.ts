export class Book {


  constructor(
    private _ean:number,
    private _title: string,
    private _author: string,
    private _genre: string,
    private _pagNumber: number,
    private _language: string,
    private _publicationYear: number,
    private _publisher: string,
    private _image: string,
    private _plot: string
  ) {

  }

  get ean(): number {
    return this._ean;
  }

  set ean(value: number) {
    this._ean = value;
  }
  get author(): string {
    return this._author;
  }

  set author(value: string) {
    this._author = value;
  }

  get genre(): string {
    return this._genre;
  }

  set genre(value: string) {
    this._genre = value;
  }

  get pagNumber(): number {
    return this._pagNumber;
  }

  set pagNumber(value: number) {
    this._pagNumber = value;
  }

  get language(): string {
    return this._language;
  }

  set language(value: string) {
    this._language = value;
  }


  get publicationYear(): number {
    return this._publicationYear;
  }

  set publicationYear(value: number) {
    this._publicationYear = value;
  }

  get publisher(): string {
    return this._publisher;
  }
  set publisher(value: string) {
    this._publisher = value;
  }

  get image(): string {
    return this._image;
  }

  set image(value: string) {
    this._image = value;
  }

  get plot(): string {
    return this._plot;
  }

  set plot(value: string) {
    this._plot = value;
  }
  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

}

