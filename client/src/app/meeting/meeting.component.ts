import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-meeting',
  templateUrl: './meeting.component.html',
  styleUrls: ['./meeting.component.scss']
})
export class MeetingComponent implements OnInit {
  @Input() date = '';
  @Input() hourStart = '';
  @Input() hourEnd = '';

  constructor() { }

  ngOnInit(): void {
  }

}
