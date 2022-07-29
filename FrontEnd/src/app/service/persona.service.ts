import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Persona } from '../model/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  expURL = 'https://backproyectointegradorap.herokuapp.com/personas/';

  constructor(private httpClient: HttpClient) { }

  public list(): Observable<Persona[]>{
    return this.httpClient.get<Persona[]>(this.expURL + 'list');
  }

  public detail(id: number): Observable<Persona>{
    return this.httpClient.get<Persona>(this.expURL + `detail/${id}`);
  } 

  public save(persona: Persona): Observable<any>{
    return this.httpClient.post<any>(this.expURL + 'create', persona);
  }

  public update(id: number, persona: Persona ): Observable<any>{
    return this.httpClient.put<any>(this.expURL + `update/${id}`, persona);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.expURL + `delete/${id}`);
  }
  }

    
