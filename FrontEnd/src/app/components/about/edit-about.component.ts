import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { About } from 'src/app/model/about.model';
import { AboutService } from 'src/app/service/about.service';

@Component({
  selector: 'app-edit-about',
  templateUrl: './edit-about.component.html',
  styleUrls: ['./edit-about.component.css']
})
export class EditAboutComponent implements OnInit {
  aboutEdit: About = null;

  constructor(private aboutService: AboutService, private activatedRouter: ActivatedRoute,
    private router: Router) { }
  
  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.aboutService.detail(id).subscribe(
      data => {
        this.aboutEdit = data;
      }, err => {
        alert("Error in project edition");
        this.router.navigate(['']);
      }
    )
  }
  
  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.aboutService.update(id, this.aboutEdit).subscribe(
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
  