import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

const MEETING_API = 'http://localhost:8080/api/meetings/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class MeetingService {

  constructor(private http: HttpClient) { }

  getMeetings(userID): Observable<any> {
    return this.http.get(MEETING_API + 'user/1');
  }

  postMeeting(body): Observable<any> {
    return this.http.post(MEETING_API, body, httpOptions);
  }
}
