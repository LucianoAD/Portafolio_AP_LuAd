import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { About } from "../model/about.model";


@Injectable({
    providedIn: 'root'
})
export class AboutService {
    expURL = 'http://localhost:8080/about/';

    constructor(private http: HttpClient) { }

    public getAbout(): Observable<About> {
        return this.http.get<About>(this.expURL + 'traer/perfil');
    }

    public save(about: About): Observable<any> {
        return this.http.post<any>(this.expURL + 'create', about);
    }


    public editAbout(id: number, about: About): Observable<any> {
        return this.http.put<any>(this.expURL + `edit/${id}`, about);
    }
}
