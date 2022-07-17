import { NgModule } from '@angular/core';
import { RouterModule, Routes, Router } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { MainpageComponent } from './mainpage/mainpage.component';
import { AppComponent } from './app.component';

const routes: Routes = [
  { path: '', redirectTo: 'AppComponent', pathMatch: 'full' },
  {path:'login', component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
