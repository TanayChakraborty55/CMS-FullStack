import { Component } from '@angular/core';
import { CourseService } from '../course.service';
import {  Router } from '@angular/router';
import { Course } from '../course';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent {

  constructor(private _service : CourseService, private route : Router){}


  course : Course ={
    id: 0,
    title: '',
    description: ''
  }
  insId: number =0;

  addCourse(){
    this._service.addCourse(this.course,this.insId).subscribe({
      next:(data) => {
        console.log("Course added to the Record",data);
        alert("Course added successFully")
        this.route.navigate(["/course/getAll"])
      },
      error : (err) => {
        console.error("Error while adding Course :",err);
        
      }
    })
  }

  


}
