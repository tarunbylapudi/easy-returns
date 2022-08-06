import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule} from '@angular/material/button';
import { ReactiveFormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatTabsModule} from '@angular/material/tabs';
import { FormsModule } from '@angular/forms';
import {MatIconModule} from '@angular/material/icon';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { ProcessingDetailsComponent } from './processing-details/processing-details.component';
import { ConfirmationComponent } from './confirmation/confirmation.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { PaymentComponent } from './payment/payment.component';
import { LoaderComponent } from './loader/loader.component';
import { LoadingIntersepterService } from './shared/Loading-intersepter.service';
import { NavbarComponent } from './navbar/navbar.component';
import { AuthCanActivateGuard } from './shared/auth-can-activate.guard';
import { TokenInterceptorService } from './shared/Token-intersepter-service';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    OrderDetailsComponent,
    ProcessingDetailsComponent,
    ConfirmationComponent,
    PageNotFoundComponent,
    PaymentComponent,
    LoaderComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatInputModule,
    MatTabsModule,
    FormsModule,
    MatIconModule,
    HttpClientModule,

   
  ],
  providers: [AuthCanActivateGuard,{provide : HTTP_INTERCEPTORS,useClass:LoadingIntersepterService,multi:true},
  {provide:HTTP_INTERCEPTORS,useClass:TokenInterceptorService,multi:true}],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
