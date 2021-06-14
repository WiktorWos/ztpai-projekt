import {Component, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {MeetingService} from '../_services/meeting.service';
import {ActivatedRoute} from '@angular/router';
import {faCheck} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-set-up-meeting-form',
  templateUrl: './set-up-meeting-form.component.html',
  styleUrls: ['./set-up-meeting-form.component.scss']
})
export class SetUpMeetingFormComponent implements OnInit {
  @Input() meetingID;
  isSuccess = false;
  faCheck = faCheck;

  setUpForm = new FormGroup({
    firstName: new FormControl('', [Validators.required]),
    lastName: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
  });

  constructor(private meetingService: MeetingService) { }

  ngOnInit(): void {
  }

  get firstName(): any {
    return this.setUpForm.get('firstName');
  }

  get lastName(): any {
    return this.setUpForm.get('lastName');
  }

  get email(): any {
    return this.setUpForm.get('email');
  }

  onSubmit() {
    this.meetingService.setUpMeeting(this.setUpForm.value, this.meetingID).subscribe(
      data => {
        this.isSuccess = true;
    },
      error => {
        console.log(error);
      }
    );
  }
}
