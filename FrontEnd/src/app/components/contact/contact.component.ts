import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { contact } from 'src/app/model/contact.model';
import { ContactService } from 'src/app/service/contact.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})

export class ContactComponent implements OnInit {
  contact: contact = {
    gmail: "",
    git:"",
    linkedin: "",
    hotmail: ""
    };

constructor(private contactService: ContactService, private tokenService: TokenService, private router:Router) { }

isLogged = false;

ngOnInit(): void {
  this.cargarContact();
  if (this.tokenService.getToken()) {
    this.isLogged = true;
  } else {
    this.isLogged = false;
  }
}

cargarContact(): void {
  this.contactService.detail(1).subscribe(data => { this.contact = data; })
}

delete(id?: number){
  if(id != undefined){
    this.contactService.delete(id).subscribe(
      data => {
        this.cargarContact();
      }, err => {
        alert("No se pudo borrar la descripcion");
      }
    )
  }
}


 editContact() {
  this.router.navigate(['/editcontact'])
  document.location.href="/editcontact"
 }
}


