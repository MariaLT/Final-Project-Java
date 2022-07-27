import {LoanState} from "./LoanState";

export class LoanStateDTO{


  constructor(
    private _loanState: LoanState
  ) {

  }


  get loanState(): LoanState {
    return this._loanState;
  }

  set loanState(value: LoanState) {
    this._loanState = value;
  }

  public toJSON(): any {
    return {
      loanState: this.loanState,
    };
  }
}
