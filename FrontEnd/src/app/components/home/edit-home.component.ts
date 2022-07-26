import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-edit-home',
  templateUrl: './edit-home.component.html',
  styleUrls: ['./edit-home.component.css']
})

export class EditHomeComponent implements OnInit {
  personaEdit: Persona = null;
  isLogged = false;
constructor(private personaService: PersonaService, private activatedRouter: ActivatedRoute,
  private router: Router, private tokenService: TokenService) { }

ngOnInit(): void {
  const id = this.activatedRouter.snapshot.params['id'];
  this.personaService.detail(id).subscribe(
    data => {
      this.personaEdit = data;
    }, err => {
      alert("Error in project edition");
      this.router.navigate(['']);
    }
  )


if (this.tokenService.getToken()) {
  this.isLogged = true;
} else {
  this.isLogged = false;
}
}

onUpdate(): void {
  const id = this.activatedRouter.snapshot.params['id'];
  this.personaService.update(id, this.personaEdit).subscribe(
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
