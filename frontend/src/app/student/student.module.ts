import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UpdatestudentComponent } from './updatestudent/updatestudent.component';
import { GetstudentComponent } from './getstudent/getstudent.component';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';
import { AddstudentComponent } from './addstudent/addstudent.component';
import { StudentRoutingModule } from './student-routing.module';



@NgModule({
  declarations: [
    UpdatestudentComponent,
    GetstudentComponent,
    AddstudentComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    StudentRoutingModule
  ],
  exports : [
    UpdatestudentComponent,
    GetstudentComponent,
    AddstudentComponent
    
  ]
})
export class StudentModule { }
