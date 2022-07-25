import {User} from "./User";

export class Role {

  constructor(
    private _id: number | null,
    private _name: string,
    // private _user: User
  ) {
  }


  get id(): number | null {
    return this._id;
  }

  set id(value: number | null) {
    this._id = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  // get user(): User {
  //   return this._user;
  // }
  //
  // set user(value: User) {
  //   this._user = value;
  // }
}
