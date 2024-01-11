import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { projects } from '../model/projects.model';

@Injectable({
  providedIn: 'root'
})
export class ProjectsService {
  expURL = 'https://backportafolio-lansel.koyeb.app/projects/';

  constructor(private httpClient: HttpClient) { }

  public list(): Observable<projects[]>{
    return this.httpClient.get<projects[]>(this.expURL + 'list');
  }

  public detail(id: number): Observable<projects>{
    return this.httpClient.get<projects>(this.expURL + `detail/${id}`);
  } 

  public save(Projects: projects): Observable<any>{
    return this.httpClient.post<any>(this.expURL + 'create', Projects);
  }

  public update(id: number, projects: projects ): Observable<any>{
    return this.httpClient.put<any>(this.expURL + `update/${id}`, projects);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.expURL + `delete/${id}`);
  }

}
