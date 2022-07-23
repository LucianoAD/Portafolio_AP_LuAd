import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { TechComponent } from './components/tech/tech.component';
import { ProjectsComponent } from './components/projects/projects.component';
import { ContactComponent } from './components/contact/contact.component';
import { AboutComponent } from './components/about/about.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { MainpageComponent } from './mainpage/mainpage.component';
import { FormsModule } from '@angular/forms';
import { interceptorProvider } from './service/interceptor-service';
import { AuthService } from './service/auth.service';
import { NewTecnologiasComponent } from './components/tech/new-tecnologias.component';
import { MatIconModule } from '@angular/material/icon';
import { EditTecnologiasComponent } from './components/tech/edit-tecnologias.component';
import { DeleteTecnologiasComponent } from './components/tech/delete-tecnologias.component';
import { EditHomeComponent } from './components/home/edit-home.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    TechComponent,
    ProjectsComponent,
    ContactComponent,
    AboutComponent,
    LoginComponent,
    MainpageComponent,
    NewTecnologiasComponent,
    EditTecnologiasComponent,
    DeleteTecnologiasComponent,
    EditHomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({}),
    HttpClientModule,
    FormsModule,
    MatIconModule
  ],
  exports: [  
    AppComponent,
    HeaderComponent,
    HomeComponent,
    TechComponent,
    ProjectsComponent,
    ContactComponent,
    AboutComponent,
    LoginComponent,
    MainpageComponent],
  providers: [
    interceptorProvider,
    AuthService 
  ],
  bootstrap: [AppComponent]
})
export class AppModule { 
  constructor() {
  }
}
