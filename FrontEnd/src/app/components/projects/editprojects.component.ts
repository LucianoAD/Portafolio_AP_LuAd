import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { projects } from 'src/app/model/projects.model';
import { ProjectsService } from 'src/app/service/projects.service';

@Component({
  selector: 'app-editprojects',
  templateUrl: './editprojects.component.html',
  styleUrls: ['./editprojects.component.css']
})
export class EditprojectsComponent implements OnInit {
  projectsEdit: projects = null;

constructor(private projectsService: ProjectsService, private activatedRouter: ActivatedRoute,
  private router: Router) { }

ngOnInit(): void {
  const id = this.activatedRouter.snapshot.params['id'];
  this.projectsService.detail(id).subscribe(
    data => {
      this.projectsEdit = data;
    }, err => {
      alert("Error in project edition");
      this.router.navigate(['']);
    }
  )
}

onUpdate(): void {
  const id = this.activatedRouter.snapshot.params['id'];
  this.projectsService.update(id, this.projectsEdit).subscribe(
    data => {
      this.router.navigate(['']);
      window.location.reload()
    }, err => {
      alert("Error in project modification");
      this.router.navigate(['']);
      
    }
  )
}

cancel(): void{
  this.router.navigate(['']);
}

 

}
