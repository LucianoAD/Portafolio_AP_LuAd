import { NgModule } from '@angular/core';
import { RouterModule, Routes, Router } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { NewTecnologiasComponent } from './components/tech/new-tecnologias.component';
import { EditTecnologiasComponent } from './components/tech/edit-tecnologias.component';
import { EditHomeComponent } from './components/home/edit-home.component';

const routes: Routes = [
  
  { path: '', redirectTo: 'AppComponent', pathMatch: 'full' },
  { path:'home', redirectTo: 'HomeComponent'},
  { path:'login', component: LoginComponent },
  { path:'newtech', component: NewTecnologiasComponent },
  { path:'edittech/:id', component: EditTecnologiasComponent },
  { path:'editar/:id', component: EditHomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
