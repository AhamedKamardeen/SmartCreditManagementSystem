import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LoaderComponent } from './loader/loader.component';

@Component({
  selector: 'app-root',
  standalone:true,
  imports: [RouterOutlet,LoaderComponent],
    template: `
    <app-loader></app-loader>
    <router-outlet></router-outlet>
  `
})
export class App {
  protected readonly title = signal('credit-management-ui');
}
