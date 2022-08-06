import { Component, Injectable, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  isUserLoggedIn


  homeImage = "assets/images/home_image.png";

  constructor(private router: Router, private authentication: AuthenticationService) { }

  ngOnInit(): void {
    
    //this.isUserLoggedIn = !!this.authentication.isUserLogedIn();
    if(this.authentication.isUserLogedIn()){
      this.router.navigate(['/service-details'])
    }
  }
 
  error = null;
  isFetching = false;


  onsubmit(form: NgForm) {


    console.log(form.value);

    this.authentication.onAuthenticate(form.value).subscribe(
      (response: any) => {
        console.log(response)
        //localStorage.setItem('token', response.jwt)
        sessionStorage.setItem('jwt_token', response.jwt);
        sessionStorage.setItem('expiration_time', (Date.now() + 1000 * 60 * 30) + '');
        if (response.jwt === null) {

          return false;

        }
        this.router.navigate(['/service-details']);


      },
      error => {
        console.log(error)

        switch(error.status){
      
          case 401 :
          this.error="Invalid Username/Password!";
           break;
          case 403:
            this.error="Something went wrong!";
            break;
          default:  
          this.error="Authentication Server is down, Please try later!";
        }
        //this.error=error.error.message
        form.reset()
        console.log(this.error)
      }


    )










  }

}
