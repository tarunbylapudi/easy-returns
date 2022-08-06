import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http : HttpClient) { }

  onAuthenticate(logindetails:{userNames:String,password:String}){

    console.log(logindetails);

    return this.http.post('http://3.36.131.122:9000/authenticate',logindetails);

  }

  isUserLogedIn(){

    if(!!sessionStorage.getItem('expiration_time')&&!!sessionStorage.getItem('jwt_token'))
    {
      console.log(sessionStorage.getItem('expiration_time')!>(Date.now()+''))
      return sessionStorage.getItem('expiration_time')!>(Date.now()+'');
    }
    return false;
    
    
  }

  getToken(){
    return sessionStorage.getItem('jwt_token');
  }
}
