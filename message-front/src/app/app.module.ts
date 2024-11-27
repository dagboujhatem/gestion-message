import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ListMessagesComponent } from './components/list-messages/list-messages.component';
import { ListPartenaireComponent } from './components/list-partenaire/list-partenaire.component';
import { AddPartenaireComponent } from './components/add-partenaire/add-partenaire.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { MenuComponent } from './ui/menu/menu.component';

@NgModule({
  declarations: [
    AppComponent,
    ListMessagesComponent,
    ListPartenaireComponent,
    AddPartenaireComponent,
    NotFoundComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
