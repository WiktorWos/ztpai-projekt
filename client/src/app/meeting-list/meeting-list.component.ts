import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-meeting-list',
  templateUrl: './meeting-list.component.html',
  styleUrls: ['./meeting-list.component.scss']
})
export class MeetingListComponent implements OnInit {
  @Input() meetings: any[];

  constructor() { }

  ngOnInit(): void {
  }

}
