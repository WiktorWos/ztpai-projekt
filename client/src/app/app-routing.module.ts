import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {SetUpMeetingComponent} from './set-up-meeting/set-up-meeting.component';
import {MeetingComponent} from './meeting/meeting.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'setUp', component: SetUpMeetingComponent},
  {path: 'meeting', component: MeetingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
