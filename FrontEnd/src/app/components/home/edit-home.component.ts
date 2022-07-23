import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-edit-home',
  templateUrl: './edit-home.component.html',
  styleUrls: ['./edit-home.component.css']
})

export class EditHomeComponent implements OnInit {
  personaEdit: Persona = null;
constructor(private personaService: PersonaService, private activatedRouter: ActivatedRoute,
  private router: Router) { }

ngOnInit(): void {
  const id = this.activatedRouter.snapshot.params['id'];
  this.personaService.findPersona().subscribe(data => {this.personaEdit = data;
  }, 
    err => {
      alert("Error in form request");
      this.router.navigate(['']);
    }
  )
}

onEdit(): void {
  const id = this.activatedRouter.snapshot.params['id'];
  this.personaService.editPersona(id, this.personaEdit).subscribe(
    data => {
      this.router.navigate(['']);
    }, err => {
      alert("Error in profile modification 2");
      this.router.navigate(['']);
      
    }
  )
}

cancel(): void{
  this.router.navigate(['']);
}

}
