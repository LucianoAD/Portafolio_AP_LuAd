import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Tecnologias } from 'src/app/model/tecnologias.model';
import { TecnologiasService } from 'src/app/service/tecnologias.service';

@Component({
  selector: 'app-new-tecnologias',
  templateUrl: './new-tecnologias.component.html',
  styleUrls: ['./new-tecnologias.component.css']
})
export class NewTecnologiasComponent implements OnInit {
  
  title: string = '';
  imgtech: string = '';
  perctech: string = '';

  constructor(private tecnologiasService: TecnologiasService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const tech = new Tecnologias(this.title, this.imgtech, this.perctech);
    this.tecnologiasService.save(tech).subscribe(
      data => {
        alert("Your skill has been successfully added");
        document.location.reload();
      }, err => {
        alert("Your skill creation failed");
        this.router.navigate(['']);
      }
    )
  }
  cancel(): void{
    this.router.navigate(['']);
  }

}


