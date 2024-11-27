import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Message} from "../models/Message";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class MessagesService {

  private apiUrl = '/api/messages';
  private baseUrl = environment.apiUrl

  constructor(private http: HttpClient) { }

  getMessages(page: number, size: number): Observable<Message[]> {
    return this.http.get<Message[]>(`${this.baseUrl}${this.apiUrl}?page=${page}&size=${size}`);
  }
  getMessageById(id: number): Observable<Message> {
    return this.http.get<Message>(`${this.baseUrl}${this.apiUrl}/${id}`);
  }
}
