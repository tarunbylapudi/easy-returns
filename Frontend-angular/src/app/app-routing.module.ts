import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConfirmationComponent } from './confirmation/confirmation.component';
import { LoginComponent } from './login/login.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PaymentComponent } from './payment/payment.component';
import { ProcessingDetailsComponent } from './processing-details/processing-details.component';
import { AuthCanActivateGuard } from './shared/auth-can-activate.guard';


const routes: Routes = [
  { path: '', component: LoginComponent },
  {path : 'login',component : LoginComponent},
  {path : 'service-details',component : OrderDetailsComponent,canActivate:[AuthCanActivateGuard]},
  {path : 'processing-details',component : ProcessingDetailsComponent,canActivate:[AuthCanActivateGuard]},
  {path : 'payment',component : PaymentComponent,canActivate:[AuthCanActivateGuard ]},
  {path:'confirmation',component: ConfirmationComponent,canActivate:[ AuthCanActivateGuard ]},
   {path:'**',component: PageNotFoundComponent}
];
//,canDeactivate:[DeactivateGuardService]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
