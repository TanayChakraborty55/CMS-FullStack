import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GetCourseComponent } from './get-course/get-course.component';
import { CourseRoutingModule } from './course-routing.module';
import { FormsModule } from '@angular/forms';
import { AddCourseComponent } from './add-course/add-course.component';
import { UpdateCourseComponent } from './update-course/update-course.component';



@NgModule({
  declarations: [
    GetCourseComponent,
    AddCourseComponent,
    UpdateCourseComponent
  ],
  imports: [
    CommonModule,
    CourseRoutingModule,
    FormsModule
  ],
  exports:[
    GetCourseComponent
  ]
})
export class CourseModule { }
