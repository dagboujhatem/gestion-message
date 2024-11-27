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
import { MessageDetailComponent } from './components/message-detail/message-detail.component';
import { MenuComponent } from './ui/menu/menu.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatButtonModule} from "@angular/material/button";
import {MatDialogModule} from "@angular/material/dialog";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatMenuModule} from "@angular/material/menu";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {MatInputModule} from "@angular/material/input";

let materialModules = [
  MatTableModule,
  MatPaginatorModule,
  MatButtonModule,
  MatDialogModule,
  MatToolbarModule,
  MatMenuModule,
  MatFormFieldModule,
  MatInputModule,
  MatSelectModule,
]

@NgModule({
  declarations: [
    AppComponent,
    ListMessagesComponent,
    ListPartenaireComponent,
    AddPartenaireComponent,
    NotFoundComponent,
    MenuComponent,
    MessageDetailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    ... materialModules

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
