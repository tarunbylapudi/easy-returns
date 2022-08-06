import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../services/authentication.service';


@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor {

  constructor(private authservice: AuthenticationService) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if(req.url.includes('authenticate'))
    return next.handle(req)
    let tokinizedReq =req.clone({
      setHeaders :{
          Authorization : `Bearer ${this.authservice.getToken()}`
      }
    })
     return next.handle(tokinizedReq)
  }
}