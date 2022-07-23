import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Persona } from '../model/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  expURL = 'http://localhost:8080/persona/';

  constructor(private http: HttpClient) { }

  public getPersona(): Observable<Persona>{
    return this.http.get<Persona>(this.expURL+'traer');
  }

    public findPersona(): Observable<Persona>{
      return this.http.get<Persona>(this.expURL+'traer/perfil');
    }

    public save(persona: Persona): Observable<any>{
      return this.http.post<any>(this.expURL + 'crear', persona);
    }

  public editPersona(id: number, persona: Persona ): Observable<any>{
      return this.http.put<any>(this.expURL + `editar/${id}`, persona);
    }

    
}
