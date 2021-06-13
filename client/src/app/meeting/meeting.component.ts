import {Component, Input, OnInit} from '@angular/core';
import {MeetingService} from '../_services/meeting.service';

@Component({
  selector: 'app-meeting',
  templateUrl: './meeting.component.html',
  styleUrls: ['./meeting.component.scss']
})
export class MeetingComponent implements OnInit {
  @Input() id: number;
  @Input() date = '';
  @Input() hourStart = '';
  @Input() hourEnd = '';

  constructor(private meetingService: MeetingService) { }

  ngOnInit(): void {
  }

  cancelMeeting() {
    this.meetingService.deleteMeeting(this.id).subscribe(
    data => {
      window.location.reload();
    },
    error => {
      console.log(error);
    });
  }

}
