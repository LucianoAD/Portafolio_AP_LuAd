import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { About } from "../model/about.model";


@Injectable({
    providedIn: 'root'
})
export class AboutService {
    expURL = 'https:/backproyectointegradorap.herokuapp.com/about/';

  constructor(private httpClient: HttpClient) { }

  public list(): Observable<About[]>{
    return this.httpClient.get<About[]>(this.expURL + 'list');
  }

  public detail(id: number): Observable<About>{
    return this.httpClient.get<About>(this.expURL + `detail/${id}`);
  } 

  public save(about: About): Observable<any>{
    return this.httpClient.post<any>(this.expURL + 'create', about);
  }

  public update(id: number, about: About ): Observable<any>{
    return this.httpClient.put<any>(this.expURL + `update/${id}`, about);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.expURL + `delete/${id}`);
  }

}
