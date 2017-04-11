import {Component, OnInit} from '@angular/core';
import {ProfileService} from './profile.service'
import {ViewEncapsulation} from '@angular/core'
import {min} from "rxjs/operator/min";
import {ConfirmationService, Message} from "primeng/primeng";
import {Kweet} from "../overview/Kweet";
import {User} from "./User";

@Component({
  selector: 'my-overview',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
  providers: [ProfileService, ConfirmationService],
  encapsulation: ViewEncapsulation.None
})
export class ProfileComponent implements OnInit {
  name = 'Angular';
  kweetMessage: string = "";
  kweetPoster: string = "Peter";
  slider: number = 10;
  kweets: Kweet[] = [];
  followers: User[] = [];
  msgs: Message[] = [];
  user:User;


  constructor(private service: ProfileService, private confirmationService: ConfirmationService) {
  }

  ngOnInit(): void {
    this.getLoggedInUser();
    this.getUserKweets();
  }

  getLoggedInUser() {
    this.service.getLoggedInUser(this.kweetPoster).subscribe(
      res => {
        debugger;
        // alert(res);
        this.showInfo("Updated user: "+ res.userName);
        this.user = res;
        this.followers = res.followers;
      },
      err => {
        console.log(err);
        this.showError(err);
      });
  }

  showError(message: string) {
    this.msgs = [];
    this.msgs.push({severity: 'error', summary: 'Error Message', detail: message});
  }

  showInfo(message: string) {
    this.msgs = [];
    this.msgs.push({severity: 'info', summary: 'Info Message', detail: message});
  }

  hideMessage() {
    this.msgs = [];
  }


  private getUserKweets() {
    this.service.getUserKweets(this.kweetPoster).subscribe(
      res => {
        debugger;
        // alert(res);
        this.kweets = res;
      },
      err => {
        console.log(err);
        this.showError(err);
      });
  }
}
