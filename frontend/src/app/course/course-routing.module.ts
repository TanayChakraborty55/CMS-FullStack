import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CourseComponent } from './course.component';
import { GetCourseComponent } from './get-course/get-course.component';
import { AddCourseComponent } from './add-course/add-course.component';
import { UpdateCourseComponent } from './update-course/update-course.component';


const routes: Routes = [
  {path: "" , component : CourseComponent},
  {path: "getAll", component : GetCourseComponent},
  {path: "addCourse", component : AddCourseComponent},
  {path: "updatecourse/:id", component : UpdateCourseComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CourseRoutingModule { }