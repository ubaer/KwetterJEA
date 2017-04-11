import { NgModule }      from '@angular/core';

import { ProfileComponent }  from './profile.component';
import { ProfileService }  from './profile.service';
import { HttpModule } from '@angular/http';
import {
  ButtonModule, SliderModule, PanelModule, InputTextModule, DataTableModule, MessagesModule, ConfirmDialogModule,
  ConfirmationService, PaginatorModule
}  from 'primeng/primeng';
import {FormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

@NgModule({
  imports:      [
    HttpModule,
    ButtonModule,
    SliderModule,
    FormsModule,
    PanelModule,
    BrowserAnimationsModule,
    InputTextModule,
    DataTableModule,
    MessagesModule,
    ConfirmDialogModule,
    PaginatorModule
  ],
  declarations: [ ProfileComponent ],
  providers:    [ ProfileService, ConfirmationService ]
})
export class ProfileModule { }
