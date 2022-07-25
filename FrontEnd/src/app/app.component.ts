import { Component } from '@angular/core';
declare const clickEvent: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'mi-portafolio';

  OnClic(){
    clickEvent();
  }

}