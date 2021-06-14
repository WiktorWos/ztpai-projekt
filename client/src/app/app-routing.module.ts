import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {SetUpMeetingComponent} from './set-up-meeting/set-up-meeting.component';
import {ProfileComponent} from './profile/profile.component';
import {SetUpMeetingFormComponent} from './set-up-meeting-form/set-up-meeting-form.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'setUp/:id', component: SetUpMeetingComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'user', component: SetUpMeetingFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
