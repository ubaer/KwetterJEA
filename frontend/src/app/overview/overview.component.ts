import {Component, OnDestroy, OnInit} from '@angular/core';
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
export class OverviewComponent implements OnInit, OnDestroy {

  name = 'Angular';
  kweetMessage: string = "";
  kweets: Kweet[] = [];
  msgs: Message[] = [];
  socket : WebSocket;

  constructor(private service: OverviewService, private confirmationService: ConfirmationService) {
  }

  ngOnInit(): void {
    this.getTimeline();

    this.socket = new WebSocket('ws://localhost:8080/Kwetter/kweetEndPoint')

    this.socket.onopen = function (event) {
    };

    this.socket.onmessage = (event) => this.handleOnMessage(event);
  };

   handleOnMessage(event : MessageEvent){
     this.msgs.push({severity: 'info', summary: 'New Kweet', detail: event.data});
  }


  ngOnDestroy(): void {
    this.socket.close();
  }

  getTimeline() {
    this.service.getTimeline().subscribe(
      res => {
        // alert(res);
        this.kweets = res;
      },
      err => {
        console.log(err);
        this.showError(err);
      });
  }

  addKweet(){
    this.service.addKweet(this.kweetMessage).subscribe();
        this.socket.send(this.kweetMessage);
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
