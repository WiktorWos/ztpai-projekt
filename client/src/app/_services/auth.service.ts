import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';


const AUTH_API = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(credentials): Observable<any> {
    return this.http.post(AUTH_API + 'login', {
      email: credentials.username,
      password: credentials.password
    }, httpOptions);
  }

  register(userDetails): Observable<any> {
    return this.http.post(AUTH_API + 'register', {
      firstName: userDetails.firstName,
      lastName: userDetails.lastName,
      email: userDetails.email,
      password: userDetails.password,
      tickets: []
    }, httpOptions);
  }

  getUser(): Observable<any> {
    return this.http.get(AUTH_API + 'user');
  }
}
