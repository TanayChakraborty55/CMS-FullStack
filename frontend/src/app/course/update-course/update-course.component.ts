import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Course } from '../course';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-update-course',
  templateUrl: './update-course.component.html',
  styleUrls: ['./update-course.component.css']
})
export class UpdateCourseComponent {

  constructor(private _service : CourseService,private routeAct : ActivatedRoute){}

  course : Course ={
    id: 0,
    title: '',
    description: ''
  }
  insId: number =0;

  ngOnInit() : void{
    const id = Number(this.routeAct.snapshot.paramMap.get('id'));
    if(id){
      this.course.id = id;
    }
  }

  updateCourse(){
    this._service.updateCourse(this.course.id,this.course,this.insId).subscribe({
      next : (x) => {
        console.log("Record Updated : ", x);
        alert("Course Updated Successfully")
      },
      error : (err) => {
        alert("Course Not found")
      }
    })
  }

}
