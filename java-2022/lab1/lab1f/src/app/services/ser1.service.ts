import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { BehaviorSubject, Observable } from 'rxjs';
import { Int1 } from '../interfaces/int1';

@Injectable({
  providedIn: 'root'
})
export class Ser1Service {
  list = new BehaviorSubject<Int1[]>([])
  url:string="http://localhost:8080/Phoness/Servlet1"
  

  constructor(private http:HttpClient) { }

  getPhones():Observable<Int1[]>{
    return this.http.get<Int1[]>(this.url);
  }

  postPhones(Phones:Int1):Observable<Int1[]>{
    return this.http.post<Int1[]>(this.url,Phones);
  }

  putPhones(Phones:Int1):Observable<Int1[]>{
    return this.http.put<Int1[]>(this.url+"/"+Phones.title,Phones);
  }

  deletePhones(Phones:Int1):Observable<Int1[]>{
    return this.http.delete<Int1[]>(this.url+"/"+Phones.title);
  }

  setList(list:Int1[]){
    this.list.next(list);
  }


}
