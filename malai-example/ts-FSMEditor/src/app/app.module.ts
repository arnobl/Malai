import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TitleComponent } from './Component/title/title.component';
import { NewButtonComponent } from './Component/new-button/new-button.component';

@NgModule({
  declarations: [
    AppComponent,
    TitleComponent,
    NewButtonComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
