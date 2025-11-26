import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private _http: HttpClient) { }

  // baseUrl = "http://localhost:3000/student/"
  baseUrl = "http://localhost:8080/api/student/"

  getAllStudents() : Observable<Student[]>{
    return this._http.get<Student[]>(this.baseUrl +'getAll');
    
  }

  updateStudentById(id : number,student :Student) : Observable<Student>{
    return this._http.put<Student>(this.baseUrl + "update/"+id , student );
  }


  deleteStudentById(id : number) : Observable<any>{
    return this._http.delete(this.baseUrl+"delete/"+id,{responseType : 'text'})
  }
  // delete/{id}

  addStudent(s : Student) : Observable<Student>{
    return this._http.post<Student>(this.baseUrl+"add",s);
  }

  getStudentById(id : number) : Observable<any>{
    return this._http.get(this.baseUrl+ "get/"+id);
  }

}
