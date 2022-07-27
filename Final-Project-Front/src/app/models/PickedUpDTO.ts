import {PICKED_UP} from "./PICKED_UP";

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

  public toJSON(): any {
    return {
      ean: this._ean
    };
  }
}


