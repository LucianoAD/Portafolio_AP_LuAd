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
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({}),
    HttpClientModule,
    FormsModule
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
