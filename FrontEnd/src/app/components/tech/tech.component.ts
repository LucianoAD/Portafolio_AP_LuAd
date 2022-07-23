import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Tecnologias } from 'src/app/model/tecnologias.model';
import { TecnologiasService } from 'src/app/service/tecnologias.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-tech',
  templateUrl: './tech.component.html',
  styleUrls: ['./tech.component.css']
})

export class TechComponent implements OnInit {
  tecnologias: Tecnologias[] = [
    {
      title: "",
      imgtech: "",
      perctech:""
    }
  ];

  constructor(private tecnologiasService: TecnologiasService, private tokenService: TokenService, private router:Router) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarTecnologias();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarTecnologias(): void {
    this.tecnologiasService.list().subscribe(data => { this.tecnologias = data; })
  }

  delete(id?: number){
    if(id != undefined){
      this.tecnologiasService.delete(id).subscribe(
        data => {
          this.cargarTecnologias();
        }, err => {
          alert("No se pudo borrar la skill");
        }
      )
    }
  }

  newtech() {
    this.router.navigate(['/newtech'])
    document.location.href="/newtech"
   }

   edittech() {
    this.router.navigate(['/edittech'])
    document.location.href="/edittech"
   }
   
}
