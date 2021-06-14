import {Component, OnInit, ViewChild} from '@angular/core';
import {AddMeetingFormComponent} from '../add-meeting-form/add-meeting-form.component';
import {CalendarComponent} from '../calendar/calendar.component';
import {TokenStorageService} from '../_services/token-storage.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  userID: any;
  meetings: any[];
  date: string;
  isAddMeetingClicked = false;
  @ViewChild(CalendarComponent) child: CalendarComponent;
  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.userID = this.tokenStorageService.getUser();
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
