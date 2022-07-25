import { NgModule } from '@angular/core';
import { RouterModule, Routes, Router } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { NewTecnologiasComponent } from './components/tech/new-tecnologias.component';
import { EditTecnologiasComponent } from './components/tech/edit-tecnologias.component';
import { EditHomeComponent } from './components/home/edit-home.component';
import { EditAboutComponent } from './components/about/edit-about.component';
import { NewprojectsComponent } from './components/projects/newprojects.component';
import { EditprojectsComponent } from './components/projects/editprojects.component';
import { EditcontactComponent } from './components/contact/editcontac.component';

const routes: Routes = [
  
  { path: '', redirectTo: 'AppComponent', pathMatch: 'full' },
  { path:'home', redirectTo: 'HomeComponent'},
  { path:'login', component: LoginComponent },
  { path:'newtech', component: NewTecnologiasComponent },
  { path:'edittech/:id', component: EditTecnologiasComponent },
  { path:'edithome/:id', component: EditHomeComponent },
  { path:'editabout/:id', component: EditAboutComponent },
  { path:'newproject', component: NewprojectsComponent },
  { path:'editproject/:id', component: EditprojectsComponent },
  { path:'editcontact/:id', component: EditcontactComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
