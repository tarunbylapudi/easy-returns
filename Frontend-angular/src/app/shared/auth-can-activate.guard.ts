import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../services/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthCanActivateGuard implements CanActivate {

  constructor(private authenticationService: AuthenticationService, private router: Router) { }
  canActivate() {
    if (this.authenticationService.isUserLogedIn()) {
      
      return true;

    }

    if(!sessionStorage.getItem('jwt_token')&&!sessionStorage.getItem('expiration_time')){
      alert('You need to Login first!')
      this.router.navigate(['login'])
      return false
    }
    alert('Session Timeout!, Please Login Again')
    this.router.navigate(['login'])
    return false;

  }

}
