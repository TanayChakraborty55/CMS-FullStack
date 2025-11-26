import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login-signup/login/login.component';
import { RegisterComponent } from './login-signup/register/register.component';


const routes: Routes = [
  {path : "",component: HomeComponent},
  { path: 'login', component: LoginComponent },
  {path: 'signup',component: RegisterComponent},
  {
    path: 'student',
    loadChildren: () => import("./student/student.module").then(m => m.StudentModule)
  },
  {
    path: 'course',
    loadChildren: () => import("./course/course.module").then(m => m.CourseModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
