import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Tecnologias } from 'src/app/model/tecnologias.model';
import { TecnologiasService } from 'src/app/service/tecnologias.service';

@Component({
  selector: 'app-edit-tecnologias',
  templateUrl: './edit-tecnologias.component.html',
  styleUrls: ['./edit-tecnologias.component.css']
})

export class EditTecnologiasComponent implements OnInit {
techEdit: Tecnologias = null;

constructor(private tecnologiasService: TecnologiasService, private activatedRouter: ActivatedRoute,
  private router: Router) { }

ngOnInit(): void {
  const id = this.activatedRouter.snapshot.params['id'];
  this.tecnologiasService.detail(id).subscribe(
    data => {
      this.techEdit = data;
    }, err => {
      alert("Error in skill modification");
      this.router.navigate(['']);
    }
  )
}

onUpdate(): void {
  const id = this.activatedRouter.snapshot.params['id'];
  this.tecnologiasService.update(id, this.techEdit).subscribe(
    data => {
      this.router.navigate(['']);
      window.location.reload()
    }, err => {
      alert("Error in skill modification");
      this.router.navigate(['']);
      
    }
  )
}

cancel(): void{
  this.router.navigate(['']);
}

}
