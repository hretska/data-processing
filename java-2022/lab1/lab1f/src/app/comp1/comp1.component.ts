import { Component, OnInit } from '@angular/core';
import { Int1 } from '../interfaces/int1';
import { Ser1Service } from '../services/ser1.service';

@Component({
  selector: 'app-comp1',
  templateUrl: './comp1.component.html',
  styleUrls: ['./comp1.component.scss']
})
export class Comp1Component implements OnInit {
  phonesList:Int1[]=[];
  constructor(private service:Ser1Service){}

  getPhones():void{
    this.service.getPhones().subscribe(
      (phones)=>{
        this.phonesList=phones;
        this.service.setList(phones);
      }
    )
  }
  ngOnInit(): void {
  }

}
