import { Component } from '@angular/core';
import {TranslateService} from "ng2-translate";

@Component({
  selector: 'my-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: [ './dashboard.component.css' ],
})
export class DashboardComponent  {
  name = 'Angular';

  constructor(private translate: TranslateService) {
    translate.addLangs(["en", "nl"]);
    translate.setDefaultLang('en');

    let browserLang = translate.getBrowserLang();
    translate.use(browserLang.match(/en|nl/) ? browserLang : 'en');
  }
}
