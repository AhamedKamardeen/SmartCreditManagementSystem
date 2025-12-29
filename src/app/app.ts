import { Component, signal } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { LoginComponent } from './login/login.component';

@Component({
  selector: 'app-root',
  standalone:true,
  imports: [RouterOutlet],
  template: `<router-outlet></router-outlet>`
})
export class App {
  constructor(private router: Router) {
  this.router.routeReuseStrategy.shouldReuseRoute = () => false;
}
  protected readonly title = signal('credit-management-ui');
}
