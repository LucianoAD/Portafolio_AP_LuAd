import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tecnologias } from '../model/tecnologias.model';


@Injectable({
  providedIn: 'root'
})
export class TecnologiasService {
  expURL = 'https://backproyectointegradorap.herokuapp.com/tech/';

  constructor(private httpClient: HttpClient) { }

  public list(): Observable<Tecnologias[]>{
    return this.httpClient.get<Tecnologias[]>(this.expURL + 'list');
  }

  public detail(id: number): Observable<Tecnologias>{
    return this.httpClient.get<Tecnologias>(this.expURL + `detail/${id}`);
  } 

  public save(tecnologias: Tecnologias): Observable<any>{
    return this.httpClient.post<any>(this.expURL + 'create', tecnologias);
  }

  public update(id: number, tecnologias: Tecnologias ): Observable<any>{
    return this.httpClient.put<any>(this.expURL + `update/${id}`, tecnologias);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.expURL + `delete/${id}`);
  }

}
