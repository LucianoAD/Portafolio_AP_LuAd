import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { projects } from 'src/app/model/projects.model';
import { ProjectsService } from 'src/app/service/projects.service';
import { TokenService } from 'src/app/service/token.service';


@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})

export class ProjectsComponent implements OnInit {
  projects: projects[] = [
    {
      title: "",
      tech: "",
      description:"",
      url: ""
    }
  ];


  constructor(private projectsService: ProjectsService, private tokenService: TokenService, private router:Router) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarProjects();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarProjects(): void {
    this.projectsService.list().subscribe(data => { this.projects = data; })
  }

  delete(id?: number){
    if(id != undefined){
      this.projectsService.delete(id).subscribe(
        data => {
          this.cargarProjects();
        }, err => {
          alert("No se pudo borrar el proyecto");
        }
      )
    }
  }

  newproject() {
    this.router.navigate(['/newproject'])
    document.location.href="/newproject"
   }

   editproject() {
    this.router.navigate(['/editproject'])
    document.location.href="/editproject"
   }
   


}
