import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Partenaire} from "../models/Partenaire";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class PartenaireService {
  private apiUrl = '/api/partenaires';
  private baseUrl = environment.apiUrl

  constructor(private http: HttpClient) { }

  addPartenaire(partenaire: Partenaire): Observable<Partenaire> {
    return this.http.post<Partenaire>(`${this.baseUrl}${this.apiUrl}`, partenaire);
  }

  deletePartenaire(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}${this.apiUrl}/${id}`);
  }

  getPartenaires(page: number, size: number): Observable<Partenaire[]> {
    return this.http.get<Partenaire[]>(`${this.baseUrl}${this.apiUrl}?page=${page}&size=${size}`);
  }

  getPartenaireById(id: number): Observable<Partenaire> {
    return this.http.get<Partenaire>(`${this.baseUrl}${this.apiUrl}/${id}`);
  }
}
