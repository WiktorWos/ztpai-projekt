import { Component, OnInit } from '@angular/core';
import {MeetingService} from '../_services/meeting.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-meeting-list',
  templateUrl: './meeting-list.component.html',
  styleUrls: ['./meeting-list.component.scss']
})
export class MeetingListComponent implements OnInit {
  meetings: any[];

  constructor(private meetingService: MeetingService) { }

  ngOnInit(): void {
    this.meetingService.getMeetings(1).subscribe((data: any[]) => {
      this.meetings = data;
    });
  }

}
