import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SetUpMeetingComponent } from './set-up-meeting.component';

describe('SetUpMeetingComponent', () => {
  let component: SetUpMeetingComponent;
  let fixture: ComponentFixture<SetUpMeetingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SetUpMeetingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SetUpMeetingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
