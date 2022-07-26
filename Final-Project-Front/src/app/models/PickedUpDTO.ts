import {PickedUp} from "./PickedUp";

export class PickedUpDTO{


  constructor(
    private _ean: number
  ){}


  get loanedBookId(): number {
    return this._ean;
  }

  set loanedBookId(value: number) {
    this._ean = value;
  }
}


