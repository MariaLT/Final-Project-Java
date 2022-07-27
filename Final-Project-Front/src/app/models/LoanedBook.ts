import {LOAN_STATE} from "./LOAN_STATE";
import {PICKED_UP} from "./PICKED_UP";


export class LoanedBook {


  constructor(
    private _ean: number,
    private _loanState: LOAN_STATE,
    private _loanDate: Date,
    private _returnDate: Date,
    private _pickedUp: PICKED_UP,
    private _userId: number | null,
  ) {
  }


  get ean(): number {
    return this._ean;
  }

  set ean(value: number) {
    this._ean = value;
  }

  get loanState(): LOAN_STATE {
    return this._loanState;
  }

  set loanState(value: LOAN_STATE) {
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


  get pickedUp(): PICKED_UP {
    return this._pickedUp;
  }

  set pickedUp(value: PICKED_UP) {
    this._pickedUp = value;
  }

  get userId(): number | null {
    return this._userId;
  }

  set userId(value: number | null) {
    this._userId = value;
  }


  public toJSON(): any {
    return {
      ean: this._ean,
      loanState: this._loanState,
      loanDate: this._loanDate,
      returnDate: this._returnDate,
      pickedUp: this._pickedUp,
      userId: this._userId,
    };
  }
}

