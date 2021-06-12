import {Component, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {MeetingService} from '../_services/meeting.service';

@Component({
  selector: 'app-add-meeting-form',
  templateUrl: './add-meeting-form.component.html',
  styleUrls: ['./add-meeting-form.component.scss']
})
export class AddMeetingFormComponent implements OnInit {
  meetingForm = new FormGroup({
    hourStart: new FormControl('', [Validators.required]),
    minuteStart: new FormControl('', [Validators.required]),
    hourEnd: new FormControl('', [Validators.required]),
    minuteEnd: new FormControl('', [Validators.required]),
  });
  hours = [];
  minutes = [];
  @Input() date: string;
  constructor(private meetingService: MeetingService) { }

  get hourStart(): any {
    return this.meetingForm.get('hourStart');
  }

  get hourEnd(): any {
    return this.meetingForm.get('hourEnd');
  }

  get minuteStart(): any {
    return this.meetingForm.get('minuteStart');
  }

  get minuteEnd(): any {
    return this.meetingForm.get('minuteEnd');
  }

  ngOnInit(): void {
    this.loadHours();
    this.loadMinutes();
  }

  onSubmit(): void {
    if (this.meetingForm.valid) {
      const hourStart = this.hourStart.value + ':' + this.minuteStart.value;
      const hourEnd = this.hourEnd.value + ':' + this.minuteEnd.value;
      const body = {
        hourStart,
        hourEnd,
        meetingDate: this.date
      };

      this.meetingService.postMeeting(body).subscribe(
        data => {
          console.log('success');
        },
        err => {
          console.log('error');
        }
      );
    }
  }

  loadHours() {
    for (let i = 1; i < 10; i++) {
      this.hours.push('0' + i);
    }
    for (let i = 10; i < 25; i++) {
      this.hours.push('' + i);
    }
  }

  loadMinutes() {
    for (let i = 0; i < 10; i++) {
      this.minutes.push('0' + i);
    }
    for (let i = 10; i < 61; i++) {
      this.minutes.push('' + i);
    }
  }
}
