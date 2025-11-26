import { Component } from '@angular/core';
import { CourseService } from '../course.service';
import { Course } from '../course';

@Component({
  selector: 'app-get-course',
  templateUrl: './get-course.component.html',
  styleUrls: ['./get-course.component.css']
})
export class GetCourseComponent {

  constructor(private _service : CourseService){}

  courseList : Course[] = []
  filteredCourses : any[] = []
  searchTerm: string = '';

  getAll(){
    this._service.getAllCourse().subscribe((data) => {
      this.courseList = data;
      this.filteredCourses = []
      console.log(data);
      
    })
  }


  deleteById(id : number){
    this._service.deleteCourseById(id).subscribe({
      next : (x) => {
        console.log("Course Deleted");
        console.log(x);
        this.getAll();
      },
      error : (err) => {
        alert("Course Cannot be Deleted");
      }
    })
  }


  onSearch(): void {
    const term = this.searchTerm.toLowerCase();
    this.filteredCourses = this.courseList.filter(course =>
      course.title.toLowerCase().includes(term) 
    );
  }

}
