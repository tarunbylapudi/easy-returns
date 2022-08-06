import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { paymentDetails } from "../data-model/paymentDetails";
import { OrderService } from "./order.service";


@Injectable({
    providedIn: 'root'
  })
export class paymentService{
    constructor(private http:HttpClient,private orderService:OrderService){ }
    //orderResponse=null
    

    getPaymentConfirmation(paymentData : paymentDetails){

        //const headers= new HttpHeaders().set('Authorization', 'Bearer '+localStorage.getItem('token'))

       return this.http.post('http://3.36.131.122:9003/payment-processing',paymentData,{responseType: 'text' as 'json'})
      // ,{headers:headers, responseType: 'text' as 'json' }
    }
}