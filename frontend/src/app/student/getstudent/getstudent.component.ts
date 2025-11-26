import { Component } from '@angular/core';
import { StudentService } from '../student.service';
import { Student } from '../student';

@Component({
  selector: 'app-getstudent',
  templateUrl: './getstudent.component.html',
  styleUrls: ['./getstudent.component.css']
})
export class GetstudentComponent {
  constructor(private _service : StudentService){}

  studentList : Student[]  = [];
  filteredStudents: any[] = [];
  searchTerm: string = '';
  studentById : number = 0;
  searchStudent : Student | null = null;

  getAll(){
    this._service.getAllStudents().subscribe((data) => {
      this.studentList = data;
      this.filteredStudents =[]
      console.log(data);
      
    })
  }

  deleteById(id : number){
    this._service.deleteStudentById(id).subscribe({
      next : (x) => {
        console.log("student deleted with id : "+ id);
        console.log(x);
        this.getAll()
      },
      error : (e) => {
        alert("Student with this id is not present")
      }
    })
  }

  

  

  getById(){
    this._service.getStudentById(this.studentById).subscribe({
      next: (data) => {
        console.log(data);
        this.studentList = [data];
        this.filteredStudents = [];
      },
      error : (err) => {
        alert("Student Not present with this id : "+ err)
        this.studentList = []
      }
    })
  }

  onSearch(): void {
    const term = this.searchTerm.toLowerCase();
    this.filteredStudents = this.studentList.filter(student =>
      student.sname.toLowerCase().includes(term) ||   // match by name
      student.email.toLowerCase().includes(term)      // optional: match by email too
    );
  }
  

}
