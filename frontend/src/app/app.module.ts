import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';


import { StudentModule } from './student/student.module';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { StudentComponent } from './student/student.component';
import { CourseModule } from './course/course.module';
import { CourseComponent } from './course/course.component';
import { LoginSignupModule } from './login-signup/login-signup.module';
import { AuthInterceptor } from './login-signup/auth.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    StudentComponent,
    CourseComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    StudentModule,
    CourseModule,
    LoginSignupModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ]
,
  bootstrap: [AppComponent]
})
export class AppModule { }
