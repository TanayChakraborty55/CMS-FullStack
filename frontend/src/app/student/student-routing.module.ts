import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentComponent } from './student.component';
import { GetstudentComponent } from './getstudent/getstudent.component';
import { AddstudentComponent } from './addstudent/addstudent.component';
import { UpdatestudentComponent } from './updatestudent/updatestudent.component';

const routes: Routes = [
  { path: '', component: StudentComponent}, 
  { path: 'getAll', component: GetstudentComponent },
  { path: 'addStudent', component: AddstudentComponent },
  { path: 'updatestudent/:id', component: UpdatestudentComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }