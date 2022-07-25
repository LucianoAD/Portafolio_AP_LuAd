import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { projects } from 'src/app/model/projects.model';
import { ProjectsService } from 'src/app/service/projects.service';

@Component({
  selector: 'app-newprojects',
  templateUrl: './newprojects.component.html',
  styleUrls: ['./newprojects.component.css']
})
export class NewprojectsComponent implements OnInit {

  title: string = '';
  tech: string = '';
  description = '';
  url: string = '';

  constructor(private projectsService: ProjectsService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const proj = new projects(this.title, this.tech, this.description, this.url);
    this.projectsService.save(proj).subscribe(
      data => {
        alert("Your project has been successfully added");
        document.location.reload();
      }, err => {
        alert("Your project creation failed");
        this.router.navigate(['']);
      }
    )
  }
  cancel(): void{
    this.router.navigate(['']);
  }

  

}

