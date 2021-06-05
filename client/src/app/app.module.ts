import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { CalendarComponent } from './calendar/calendar.component';
import { HourPickerComponent } from './hour-picker/hour-picker.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SetUpMeetingComponent } from './set-up-meeting/set-up-meeting.component';
import { LoginComponent } from './login/login.component';

import { authInterceptorProviders } from './_helpers/auth.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    CalendarComponent,
    HourPickerComponent,
    NavbarComponent,
    SetUpMeetingComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
