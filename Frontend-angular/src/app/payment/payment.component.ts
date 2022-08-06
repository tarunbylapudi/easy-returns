import { Component, HostListener, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { paymentDetails } from '../data-model/paymentDetails';
import { OrderService } from '../services/order.service';
import { paymentService } from '../services/payment.service';


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  orderResponseDetails
  amountTobePaid
  error


  constructor(private router: Router, private paymentService: paymentService, private orderService: OrderService) { }

  ngOnInit(): void {
    if (!this.orderService.getOrderResponseDetails()) {
      this.router.navigate(['/service-details'])
    }
    this.orderResponseDetails = this.orderService.getOrderResponseDetails()
    this.amountTobePaid = this.orderResponseDetails.processingCharge + this.orderResponseDetails.packagingAndDeliveryCharge

  }
  onSubmit(form: NgForm) {

    if (!form.valid) {
      this.error = "Please fill all the Payement Details!"
    }



    var paymentData: paymentDetails = {
      requestId: this.orderResponseDetails.requestId ? this.orderResponseDetails.requestId : "requestID",
      amountToBePaid: this.amountTobePaid ? this.amountTobePaid : 1000,
      creditCardNumber: form.value.creditCardNumber,
      cvv: form.value.cvv,
      cardHolderName: form.value.cardHolderName
    }
    console.log(paymentData)


    this.paymentService.getPaymentConfirmation(paymentData).subscribe(
      (Response: any) => {
        console.log(Response)
        this.router.navigate(['/confirmation'])
      },
      error => {
        console.log(error)
        if (error.error.includes("Incorrect Card Details!")) {
          this.error = "Invalid CVV!, Please Try again"
        }
        else if (error.error.includes("Card Not Found")) {
          this.error = "Invalid Credit Card!, Please Try again"
        }
        else if (!form.valid) {
          this.error = "Please Enter all the Payment Details!"
        }
        else if (error.error.includes("Server is down, Please Retry after Sometime")) {
          this.error = "Payment Server is down, Please Retry after Sometime!"
        }
        else {
          this.error = "Payment Server is down, Please Retry after Sometime!"
        }
      }
    )
  }
  @HostListener("window:beforeunload", ["$event"]) unloadHandler(event: Event) {
    console.log("Processing beforeunload...", 'Data not saved on reload');
    event.returnValue = false;
  }
}
