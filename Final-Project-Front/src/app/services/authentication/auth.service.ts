import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../../models/User";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  readonly API_URL = 'http://localhost:8080';

  constructor(
    private http: HttpClient
  ) {
  }

  isAuthenticated(): boolean {
    const token: string | null = localStorage.getItem('currentUser');
    return token !== null;
  }

  /* for (let role of user.roles) {
            if (role.name === 'LIBRARIAN') {
              console.log('Librarian logged in');
              this.router.navigate(['/librarian-home']);
            } else if (role.name === 'STUDENT') {
              console.log('Student logged in');
              this.router.navigate(['/student-home']);
            }*/
  isLibrarian(): boolean {
    const token: string | null = localStorage.getItem('currentUser');
    if (token !== null) {
      const user: User = JSON.parse(token);
      for (let role of user.roles) {
        if (role.name === 'LIBRARIAN') {
          return true;
        }
      }
    }
    return false;
  }


  register(username: string, password: string): Observable<User> {

    const user: User = new User(
      null,
      username,
      password,
      []
    );

    return this.http.post<User>(`${this.API_URL}/users`, user);

  }

  login(username: string, password: string): Observable<User> {
    let headers = new HttpHeaders();
    headers = headers.append('Authorization', 'Basic ' + btoa(`${username}:${password}`));

    return this.http.get<User>(`${this.API_URL}/login`, {headers: headers});

  }

  logout(): void {
    // Remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }
}
