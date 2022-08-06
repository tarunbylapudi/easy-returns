import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { finalize, Observable } from 'rxjs';
import { LoaderService } from '../services/loader.service';

@Injectable({
  providedIn: 'root'
})
export class LoadingIntersepterService implements HttpInterceptor {

  constructor(public loader: LoaderService) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    
    this.loader.isLoading.next(true);
    return next.handle(req).pipe(
      finalize(
        () => {
          this.loader.isLoading.next(false);
        }
      )
    )
    

  }
}
