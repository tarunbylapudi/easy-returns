import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { orderData } from '../data-model/orderData';
import { orderResponse } from '../data-model/orderResponse';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  orderResponseDetails = null;

  constructor(private http: HttpClient) { }

  sendorderDetails(orderdetails: orderData) {

    const Params = new HttpParams(
      {
        fromObject: {
          userName: orderdetails.userName,
          contactNumber: orderdetails.contactNumber,
          componentType: orderdetails.componentType,
          componentName: orderdetails.componentName,
          quantity: orderdetails.quantity
        }
      }
    );
    //const headers= new HttpHeaders().set('Authorization', 'Bearer '+localStorage.getItem('token'))
     

    return this.http.get('http://3.36.131.122:9003/component-processing',{ params: Params });
  }

  setOrderResponseDetails(data: orderResponse) {

    this.orderResponseDetails = data;


  }

  getOrderResponseDetails() {

    return this.orderResponseDetails

  }

}
