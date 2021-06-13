import { Component, OnInit } from '@angular/core';
import {faCheck, faUserAlt} from '@fortawesome/free-solid-svg-icons';
import {TokenStorageService} from '../_services/token-storage.service';

interface User {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
}

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.scss']
})
export class UserInfoComponent implements OnInit {
  faUser = faUserAlt;
  faCheck = faCheck;
  user: User;
  isCopied = false;

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();
  }

  copyToClipboard() {
    const baseURL: string = window.location.origin;
    const url = baseURL + '/setUp/' + this.user.id;
    const selBox = document.createElement('textarea');
    selBox.style.position = 'fixed';
    selBox.style.left = '0';
    selBox.style.top = '0';
    selBox.style.opacity = '0';
    selBox.value = url;
    document.body.appendChild(selBox);
    selBox.focus();
    selBox.select();
    document.execCommand('copy');
    document.body.removeChild(selBox);
    this.isCopied = true;
  }

}
