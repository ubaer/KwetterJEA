import {Component, OnInit} from '@angular/core';
import {OverviewService} from './overview.service'
import {ViewEncapsulation} from '@angular/core'
import {min} from "rxjs/operator/min";
import {ConfirmationService, Message} from "primeng/primeng";
import {Kweet} from "./Kweet";
import {User} from "../profile/User";

@Component({
  selector: 'my-profile',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css'],
  providers: [OverviewService, ConfirmationService],
  encapsulation: ViewEncapsulation.None
})
export class OverviewComponent implements OnInit {
  name = 'Angular';
  kweetMessage: string = "";
  kweetPoster: string = "Peter";
  slider: number = 10;
  licensePlate: string;
  kweets: Kweet[] = [];
  msgs: Message[] = [];


  constructor(private service: OverviewService, private confirmationService: ConfirmationService) {
  }

  ngOnInit(): void {
    this.getTimeline();
  }

  getTimeline() {
    this.service.getTimeline().subscribe(
      res => {
        debugger;
        // alert(res);
        this.showInfo(" Retrieved: " + res.length + " kweets");
        this.kweets = res;
      },
      err => {
        console.log(err);
        this.showError(err);
      });
  }

  addKweet(){
    this.service.addKweet(this.kweetMessage);
        this.showInfo("Kweet posted!");
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


}
