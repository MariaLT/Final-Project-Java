import {LoanState} from "./LoanState";

export class LoanedBook {


  constructor(
    private _loanedBookId: number,
    private _ean: number,
    private _loanState:LoanState,
    private _loanDate: Date,
    private _returnDate: Date,
    private _userId: number| null,

  ) {
  }

  get loanedBookId(): number {
    return this._loanedBookId;
  }

  set loanedBookId(value: number) {
    this._loanedBookId = value;
  }

  get ean(): number {
    return this._ean;
  }

  set ean(value: number) {
    this._ean = value;
  }

  get loanState(): LoanState {
    return this._loanState;
  }

  set loanState(value: LoanState) {
    this._loanState = value;
  }

  get loanDate(): Date {
    return this._loanDate;
  }

  set loanDate(value: Date) {
    this._loanDate = value;
  }

  get returnDate(): Date {
    return this._returnDate;
  }

  set returnDate(value: Date) {
    this._returnDate = value;
  }

  get userId(): number| null {
    return this._userId;
  }

  set userId(value: number| null) {
    this._userId = value;
  }

}

