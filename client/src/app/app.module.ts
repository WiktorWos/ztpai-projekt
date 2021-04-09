import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CalendarComponent } from './calendar/calendar.component';
import { HourPickerComponent } from './hour-picker/hour-picker.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SetUpMeetingComponent } from './set-up-meeting/set-up-meeting.component';

@NgModule({
  declarations: [
    AppComponent,
    CalendarComponent,
    HourPickerComponent,
    NavbarComponent,
    SetUpMeetingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
