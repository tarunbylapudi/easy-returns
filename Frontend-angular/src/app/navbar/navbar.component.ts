import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router:Router,public authService:AuthenticationService) { }
isUserLogedIn



logo4="assets/images/logo4.png";

  ngOnInit(): void {
    this.isUserLogedIn=this.authService.isUserLogedIn(); 
  }

  onLogout(){
   if(confirm("Do you Want To Logout ?"))
   {
    sessionStorage.removeItem('jwt_token');
    sessionStorage.removeItem('expiration_time')
    this.router.navigate(['/login'])
   }
   
  
   

   
  }

}
