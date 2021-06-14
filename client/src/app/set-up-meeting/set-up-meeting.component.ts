import { Component, OnInit } from '@angular/core';
import {MeetingService} from '../_services/meeting.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-set-up-meeting',
  templateUrl: './set-up-meeting.component.html',
  styleUrls: ['./set-up-meeting.component.scss']
})
export class SetUpMeetingComponent implements OnInit {
  meetings: any[];
  meetingID: number;
  isSetUpClicked = false;
  sub: any;
  userID: number;

  constructor(private route: ActivatedRoute) {
    this.meetings = [];
  }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.userID = +params.id;
    });
  }

  handleMeetingsOnClickedDay(meetings: any[]) {
    this.meetings = meetings;
  }

  handleSetUpClick(id) {
    this.meetingID = id;
    this.isSetUpClicked = true;
  }
}
