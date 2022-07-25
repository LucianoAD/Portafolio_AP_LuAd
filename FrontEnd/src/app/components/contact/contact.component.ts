import { Component, OnInit } from '@angular/core';
import { contact } from 'src/app/model/contact.model';
import { ContactService } from 'src/app/service/contact.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  contact: contact = new contact("","","","");

  constructor(public contactService: ContactService, private tokenService: TokenService) {}

  cargarContact(): void {
    this.contactService.getContact().subscribe(data => {this.contact = data})
  }

  isLogged = false;

  ngOnInit(): void {
    this.cargarContact();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

}
