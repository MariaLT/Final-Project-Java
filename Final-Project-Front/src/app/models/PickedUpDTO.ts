import {PickedUp} from "./PickedUp";

export class PickedUpDTO{


  constructor(
    private _loanedBookId: number
  ){}


  get loanedBookId(): number {
    return this._loanedBookId;
  }

  set loanedBookId(value: number) {
    this._loanedBookId = value;
  }
}


