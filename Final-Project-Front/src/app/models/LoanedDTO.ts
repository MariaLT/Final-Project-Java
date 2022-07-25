export class LoanedDTO{

  constructor(
    private _ean: number,
    private _userId:number | null
  ){}


  get ean(): number {
    return this._ean;
  }

  set ean(value: number) {
    this._ean = value;
  }

  get userId(): number | null{
    return this._userId;
  }

  set userId(value: number | null) {
    this._userId = value;
  }
}
