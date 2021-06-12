import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {HttpClientModule} from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { CalendarComponent } from './calendar/calendar.component';
import { HourPickerComponent } from './hour-picker/hour-picker.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SetUpMeetingComponent } from './set-up-meeting/set-up-meeting.component';
import { LoginComponent } from './login/login.component';

import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { MeetingComponent } from './meeting/meeting.component';
import { MeetingListComponent } from './meeting-list/meeting-list.component';
import { AddMeetingFormComponent } from './add-meeting-form/add-meeting-form.component';
import { ProfileComponent } from './profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    CalendarComponent,
    HourPickerComponent,
    NavbarComponent,
    SetUpMeetingComponent,
    LoginComponent,
    MeetingComponent,
    MeetingListComponent,
    AddMeetingFormComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
