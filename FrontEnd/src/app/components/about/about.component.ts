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
  about: About = new About("","","","","","");

  constructor(public aboutService: AboutService, private tokenService: TokenService, private router:Router) {}

  cargarAbout(): void {
    this.aboutService.getAbout().subscribe(data => {this.about = data})
  }

  isLogged = false;

  ngOnInit(): void {
    this.cargarAbout();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

}
