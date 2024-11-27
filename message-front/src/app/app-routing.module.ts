import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListPartenaireComponent} from "./components/list-partenaire/list-partenaire.component";
import {ListMessagesComponent} from "./components/list-messages/list-messages.component";
import {AddPartenaireComponent} from "./components/add-partenaire/add-partenaire.component";
import {NotFoundComponent} from "./components/not-found/not-found.component";

const routes: Routes = [
  { path: '', redirectTo: '/partners', pathMatch: 'full' },
  { path: 'partners', component: ListPartenaireComponent },
  { path: 'messages', component: ListMessagesComponent },
  { path: 'add-partner', component: AddPartenaireComponent },
  { path: '**', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
