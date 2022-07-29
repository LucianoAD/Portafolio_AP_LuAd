import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { contact } from '../model/contact.model';

@Injectable({
  providedIn: 'root'
})

export class ContactService {
    expURL = 'https://backproyectointegradorap.herokuapp.com/contact/';

  constructor(private httpClient: HttpClient) { }

  public list(): Observable<contact[]>{
    return this.httpClient.get<contact[]>(this.expURL + 'list');
  }

  public detail(id: number): Observable<contact>{
    return this.httpClient.get<contact>(this.expURL + `detail/${id}`);
  } 

  public save(contact: contact): Observable<any>{
    return this.httpClient.post<any>(this.expURL + 'create', contact);
  }

  public update(id: number, contact: contact ): Observable<any>{
    return this.httpClient.put<any>(this.expURL + `update/${id}`, contact);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.expURL + `delete/${id}`);
  }

}
