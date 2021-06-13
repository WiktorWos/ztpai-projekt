import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {SetUpMeetingComponent} from './set-up-meeting/set-up-meeting.component';
import {AddMeetingFormComponent} from './add-meeting-form/add-meeting-form.component';
import {ProfileComponent} from './profile/profile.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'setUp', component: SetUpMeetingComponent},
  {path: 'profile', component: ProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
