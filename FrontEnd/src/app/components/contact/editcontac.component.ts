import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { contact } from 'src/app/model/contact.model';
import { ContactService } from 'src/app/service/contact.service';

@Component({
  selector: 'app-editcontac',
  templateUrl: './editcontac.component.html',
  styleUrls: ['./editcontac.component.css']
})
export class EditcontactComponent implements OnInit {
  contactEdit: contact = null;

constructor(private contactService: ContactService, private activatedRouter: ActivatedRoute,
  private router: Router) { }

ngOnInit(): void {
  const id = this.activatedRouter.snapshot.params['id'];
  this.contactService.detail(id).subscribe(
    data => {
      this.contactEdit = data;
    }, err => {
      alert("Error in information edition");
      this.router.navigate(['']);
    }
  )
}

onUpdate(): void {
  const id = this.activatedRouter.snapshot.params['id'];
  this.contactService.update(id, this.contactEdit).subscribe(
    data => {
      this.router.navigate(['']);
      window.location.reload()
    }, err => {
      alert("Error in information modification");
      this.router.navigate(['']);
      
    }
  )
}

cancel(): void{
  this.router.navigate(['']);
}
  



}
