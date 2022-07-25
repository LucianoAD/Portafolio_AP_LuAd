import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { contact } from '../model/contact.model';

@Injectable({
  providedIn: 'root'
})

export class ContactService {
    expURL = 'http://localhost:8080/contact/';

    constructor(private http: HttpClient) { }

    public getContact(): Observable<contact> {
        return this.http.get<contact>(this.expURL + 'traer/perfil');
    }

    public save(contact: contact): Observable<any> {
        return this.http.post<any>(this.expURL + 'create', contact);
    }

    public editContact(id: number, contact: contact): Observable<any> {
        return this.http.put<any>(this.expURL + `edit/${id}`, contact);
    }
}

