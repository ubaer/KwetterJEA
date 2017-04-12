import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { DashboardComponent }  from './dashboard.component';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { OverviewModule } from './overview/overview.module';
import {ProfileModule} from "./profile/profile.module";
import {TranslateModule} from "ng2-translate";


@NgModule({
  imports:      [
    BrowserModule,
    DashboardRoutingModule,
    OverviewModule,
    ProfileModule,
    TranslateModule.forRoot()
  ],

  declarations: [ DashboardComponent ],
  bootstrap:    [ DashboardComponent ]
})
export class DashboardModule { }
