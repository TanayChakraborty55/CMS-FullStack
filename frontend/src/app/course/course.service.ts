import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, ObservedValueOf } from 'rxjs';
import { Course } from './course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private _http: HttpClient) { }

  baseUrl = "http://localhost:8080/api/course/"

  getAllCourse() : Observable<Course[]> {
    return this._http.get<Course[]>(this.baseUrl+"getAll")
  }

  deleteCourseById(id : number) : Observable<any>{
    return this._http.delete(this.baseUrl + "delete/"+id,{responseType:"text"})
  }

  // getAllCourse

  updateCourse(id : number , course : Course,insId : number) : Observable<any>{
    return this._http.post(this.baseUrl + "update/"+id,course);
  }


  addCourse(c : Course,insId : number) : Observable<Course>{
    return this._http.post<Course>(this.baseUrl+"add/"+insId,c)
  }


  // getCourseById

}
