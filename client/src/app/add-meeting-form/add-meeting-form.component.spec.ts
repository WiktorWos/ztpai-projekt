import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMeetingFormComponent } from './add-meeting-form.component';

describe('AddMeetingFormComponent', () => {
  let component: AddMeetingFormComponent;
  let fixture: ComponentFixture<AddMeetingFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddMeetingFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMeetingFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
