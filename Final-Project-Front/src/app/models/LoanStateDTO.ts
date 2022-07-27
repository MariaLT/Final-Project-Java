import {LOAN_STATE} from "./LOAN_STATE";

export class LoanStateDTO{


  constructor(
    private _loanState: LOAN_STATE
  ) {

  }


  get loanState(): LOAN_STATE {
    return this._loanState;
  }

  set loanState(value: LOAN_STATE) {
    this._loanState = value;
  }

  public toJSON(): any {
    return {
      loanState: this.loanState,
    };
  }
}
