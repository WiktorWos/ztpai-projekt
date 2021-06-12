import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-set-up-meeting',
  templateUrl: './set-up-meeting.component.html',
  styleUrls: ['./set-up-meeting.component.scss']
})
export class SetUpMeetingComponent implements OnInit {
  meetings: any[];

  constructor() {
    this.meetings = [];
  }

  ngOnInit(): void {
  }

  handleMeetingsOnClickedDay(meetings: any[]) {
    this.meetings = meetings;
  }
}
