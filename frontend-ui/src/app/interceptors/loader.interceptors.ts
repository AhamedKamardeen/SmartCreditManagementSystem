import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';
import { LoaderService } from '../loader/loader.service';

@Injectable()
export class LoaderInterceptor implements HttpInterceptor {

  constructor(private loaderService: LoaderService) {}

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {

    // 1️⃣ Show loader before API call starts
    this.loaderService.show();

    // 2️⃣ Pass request to next handler (actual API call)
    return next.handle(req).pipe(

      // 3️⃣ Always hide loader when API finishes
      finalize(() => {
        this.loaderService.hide();
      })

    );
  }
}
