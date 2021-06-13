import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-meeting-list',
  templateUrl: './meeting-list.component.html',
  styleUrls: ['./meeting-list.component.scss']
})
export class MeetingListComponent implements OnInit {
  @Output() clickAddMeeting: EventEmitter<string> = new EventEmitter<string>();
  @Output() clickSetUp: EventEmitter<number> = new EventEmitter<number>();
  @Input() meetings: any[];
  @Input() date: string;
  @Input() isProfile = false;

  constructor() { }

  ngOnInit(): void {
  }

  handleSetUpClick(id) {
    this.clickSetUp.emit(id);
  }

}
