import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { orderData } from '../data-model/orderData';
import { orderResponse } from '../data-model/orderResponse';
import { OrderService } from '../services/order.service';



@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

  error

  phoneValidator = "^((\\+91-?)|0)?[0-9]{10}$"



  constructor(private router: Router, private http: HttpClient, private orderservice: OrderService) { }

  ngOnInit(): void {
   
  }


  onSubmit(form: NgForm) {



    console.log(form.value);


    this.orderservice.sendorderDetails(form.value).subscribe((value: orderResponse) => {
        console.log(value)
        this.orderservice.setOrderResponseDetails(value)
        this.router.navigate(['/processing-details']);
       
      },
      error => { console.log(error)
      
      if(error.error.message.includes("Session TimeOut, Please Login Again!")){
        this.error="Session TimeOut, Please Login Again!" 
      }
      else if(error.error.message.includes("Quantity Should be Greater than 0!")){
        this.error="Quantity Should be Greater than 0!"
      }
      else if(error.error.message.includes("Invalid Component Type")){
        this.error="Invalid Component Type!"
      }
      else{
        this.error="Package & Delivery Server is down, Please Retry after Sometime!"
      }

            }
    )




  }

}
