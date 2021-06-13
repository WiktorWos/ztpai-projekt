import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SetUpMeetingFormComponent } from './set-up-meeting-form.component';

describe('SetUpMeetingFormComponent', () => {
  let component: SetUpMeetingFormComponent;
  let fixture: ComponentFixture<SetUpMeetingFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SetUpMeetingFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SetUpMeetingFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
