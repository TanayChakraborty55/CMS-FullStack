import { Component } from '@angular/core';
import { StudentService } from '../student.service';
import { Student } from '../student';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addstudent',
  templateUrl: './addstudent.component.html',
  styleUrls: ['./addstudent.component.css']
})
export class AddstudentComponent {

  constructor(private _service : StudentService, private route : Router){}


  student : Student = {
    id:0,
    sname: '',
    email:''
  }

  addStudent(){
    this._service.addStudent(this.student).subscribe({
      next:(data) => {
        console.log("Student added to the Record",data);
        alert("Student added successFully")
        this.route.navigate(["/getAll"])
      },
      error : (err) => {
        console.error("Error while adding Student :",err);
        
      }
    })
  }

}
