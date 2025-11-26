import { Component } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-updatestudent',
  templateUrl: './updatestudent.component.html',
  styleUrls: ['./updatestudent.component.css']
})
export class UpdatestudentComponent {

  constructor(private _service : StudentService, private route : ActivatedRoute){}

  student : Student = {
    id :0,
    sname: '',
    email: ''
  }

  ngOnInit() : void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if(id){
      this.student.id = id;
    }
  }

  updateStudent(){
    this._service.updateStudentById(this.student.id,this.student).subscribe({
      next : (x) => {
        console.log("Student Updated: ",x);
        alert("Student record updated")
      },
      error : (err) => {
        alert("User Not Present")
      }
    })
  }

}
