import {User} from "./User";

export class Role {

  constructor(
    private _id: number | null,
    private _roleName: string,
    // private _user: User
  ) {
  }


  get id(): number | null {
    return this._id;
  }

  set id(value: number | null) {
    this._id = value;
  }

  get roleName(): string {
    return this._roleName;
  }

  set roleName(value: string) {
    this._roleName = value;
  }

  // get user(): User {
  //   return this._user;
  // }
  //
  // set user(value: User) {
  //   this._user = value;
  // }
}
