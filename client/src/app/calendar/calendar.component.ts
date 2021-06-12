import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {MeetingService} from '../_services/meeting.service';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.scss']
})
export class CalendarComponent implements OnInit {
  date: Date;
  days: number[];
  prevDays: number[];
  monthList = [
    { value: 1, text: 'Jan' },
    { value: 2, text: 'Feb'},
    { value: 3, text: 'Mar' },
    { value: 4, text: 'Apr' },
    { value: 5, text: 'May' },
    { value: 6, text: 'June' },
    { value: 7, text: 'July' },
    { value: 8, text: 'Aug' },
    { value: 9, text: 'Sep' },
    { value: 10, text: 'Oct' },
    { value: 11, text: 'Nov' },
    { value: 12, text: 'Dec' }
  ];

  selectedMonth: number;
  meetings: any[];
  currentMonthMeetings: any[];

  meetingDays: number[];

  @Output() meetingsOnClickedDay: EventEmitter<any[]> = new EventEmitter();

  constructor(private meetingService: MeetingService) {
    this.initArrays();
    this.date = new Date();
    this.selectedMonth = this.date.getMonth() + 1;
  }

  initArrays() {
    this.days = [];
    this.prevDays = [];
    this.meetings = [];
    this.currentMonthMeetings = [];
    this.meetingDays = [];
  }

  ngOnInit(): void {
    this.initArrays();
    const year = this.date.getFullYear();
    this.fetchMeetings();
    this.getCurrentMonthMeetings();
    this.renderDays(this.selectedMonth, year);
  }

  renderDays(month, year): void {
    let firstDayOfWeek = this.getFirstOfMonthDayOfWeek(month - 1, year);
    firstDayOfWeek = firstDayOfWeek === 0 ? 7 : firstDayOfWeek;
    const daysNum = this.getDaysInMonth(month, year);
    const previousDaysNum = this.getDaysInMonth(month - 1, year);
    for (let i = previousDaysNum - firstDayOfWeek + 1; i < previousDaysNum; i++) {
      this.prevDays.push(i + 1);
    }
    for (let i = 1; i <= daysNum; i++) {
      this.days.push(i);
    }
  }

  getDaysInMonth(month, year): number {
    return new Date(year, month, 0).getDate();
  }

  getFirstOfMonthDayOfWeek(month, year): number {
    const firstDayOfMonth = new Date(year, month, 1);
    return firstDayOfMonth.getDay();
  }

  onChangeObj(newObj) {
    this.selectedMonth = newObj;
    this.meetingsOnClickedDay.emit([]);
    this.ngOnInit();
  }

  fetchMeetings(): void {
    this.meetingService.getMeetings(1).subscribe((data: any[]) => {
      this.meetings = data;
      this.getCurrentMonthMeetings();
    });
  }

  getCurrentMonthMeetings(): void {
    this.meetings.forEach((meeting) => {
      const meetingDate: Date = new Date(meeting.meetingDate);
      if (this.isDateInCurrentMonth(meetingDate)) {
        this.currentMonthMeetings.push(meeting);
        this.meetingDays.push(meetingDate.getDate());
      }
    });
  }

  isDateInCurrentMonth(meetingDate): boolean {
    const nextMonthDate: Date = new Date(this.date.getFullYear(), this.selectedMonth, 1);
    const lastMonthDate: Date = new Date(this.date.getFullYear(), this.selectedMonth - 1, 0);
    return meetingDate > this.date && meetingDate < nextMonthDate && meetingDate > lastMonthDate;
  }

  selectDay(event) {
    const meetings = [];
    const day: string = event.target.innerHTML;
    this.currentMonthMeetings.forEach((meeting) => {
      const meetingDate: Date = new Date(meeting.meetingDate);
      const meetingDay: number = meetingDate.getDate();
      if (meetingDay.toString() === day) {
        meetings.push(meeting);
      }
    });
    this.meetingsOnClickedDay.emit(meetings);
  }
}
