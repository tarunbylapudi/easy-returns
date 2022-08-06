import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-processing-details',
  templateUrl: './processing-details.component.html',
  styleUrls: ['./processing-details.component.css']
})
export class ProcessingDetailsComponent implements OnInit {
  //,IDeactivateGuard

  orderResponseDetails=null;

  constructor(private router:Router,private orderService:OrderService) { }

  ngOnInit(): void {
    if (!this.orderService.getOrderResponseDetails()) {
      this.router.navigate(['/service-details'])
    }
    this.orderResponseDetails=this.orderService.getOrderResponseDetails()
    

  }

  onClick(){

    this.router.navigate(['/payment']);

  }

  @HostListener("window:beforeunload", ["$event"]) unloadHandler(event: Event) {
    console.log("Processing beforeunload...", 'Data not saved on reload');
    event.returnValue = false;
}
  

}
