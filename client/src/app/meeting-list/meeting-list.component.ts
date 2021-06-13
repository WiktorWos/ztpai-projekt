import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-meeting-list',
  templateUrl: './meeting-list.component.html',
  styleUrls: ['./meeting-list.component.scss']
})
export class MeetingListComponent implements OnInit {
  @Output() clickAddMeeting: EventEmitter<string> = new EventEmitter<string>();
  @Input() meetings: any[];
  @Input() date: string;

  constructor() { }

  ngOnInit(): void {
  }

}
