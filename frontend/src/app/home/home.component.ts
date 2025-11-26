import { Component, OnInit } from '@angular/core';
import { StudentService } from '../student/student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent  implements OnInit{
  studentCount : number =0;

  constructor(private studentService : StudentService , private router : Router){}

  ngOnInit() : void {
    this.studentService.getAllStudents().subscribe(data => {
      this.studentCount = data.length;
    });

  }

  goToLogin() {
    this.router.navigate(['/login']);
  }

  goToSignup(){
    this.router.navigate(['/signup'])
  }
}
