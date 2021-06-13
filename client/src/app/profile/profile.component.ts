import {Component, OnInit, ViewChild} from '@angular/core';
import {AddMeetingFormComponent} from '../add-meeting-form/add-meeting-form.component';
import {CalendarComponent} from '../calendar/calendar.component';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  meetings: any[];
  date: string;
  isAddMeetingClicked = false;
  @ViewChild(CalendarComponent) child: CalendarComponent;
  constructor() { }

  ngOnInit(): void {
  }

  handleMeetingsOnClickedDay(meetings: any[]) {
    this.meetings = meetings;
  }

  handleClickedDate(date: string) {
    this.date = date;
  }

  handleClickAddMeeting(date: string) {
    this.isAddMeetingClicked = true;
  }

  handleAddMeetingSubmit() {
    this.isAddMeetingClicked = false;
    window.location.reload();
  }
}
