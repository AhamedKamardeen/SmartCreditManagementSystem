import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsersService } from './user.service';

@Component({
  selector: 'app-users',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UsersComponent implements OnInit {

  users: any[] = [];
  loading = true;

  constructor(private usersService: UsersService) {}
ngOnInit(): void {
  this.loading = true;

  this.usersService.getAllUsers().subscribe({
    next: (data) => {
      this.users = data;
      this.loading = false;
    },
    error: () => {
      this.loading = false;
    }
  });
}
}
