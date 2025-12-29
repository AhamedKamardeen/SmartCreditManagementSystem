// src/app/login/login.component.ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dash',
  templateUrl: './dashboard.component.html',
  standalone: true,
})
export class DashboardComponent {
  constructor(private router: Router) {
    
  }

  logout() {
  localStorage.removeItem('token');
  this.router.navigate(['/login']);
}

}
