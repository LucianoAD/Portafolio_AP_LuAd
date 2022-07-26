import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { About } from 'src/app/model/about.model';
import { TokenService } from 'src/app/service/token.service';
import { AboutService } from 'src/app/service/about.service';


@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {
  about: About = 
    {
      imgaboutme: "",
      mydescription: "",
      myinterest1:"",
      myinterest2: "",
      myinterest3: "",
      myinterest4: "",
      
    };

  constructor(private aboutService: AboutService, private tokenService: TokenService, private router:Router) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarAbout();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarAbout(): void {
    this.aboutService.detail(1).subscribe(data => { this.about = data; })
  }

  delete(id?: number){
    if(id != undefined){
      this.aboutService.delete(id).subscribe(
        data => {
          this.cargarAbout();
        }, err => {
          alert("No se pudo borrar la descripcion");
        }
      )
    }
  }


   editproject() {
    this.router.navigate(['/editabout'])
    document.location.href="/editabout"
   }
   


}


