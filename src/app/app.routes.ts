import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AuthGuard } from './auth/auth.guard';
import { UsersComponent } from './user/user.component';
import { LayoutComponent } from './layout/layout.component';

export const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
//     { path: 'dashboard', component: DashboardComponent , canActivate: [AuthGuard]},
//     {
//   path: 'users',
//   component:UsersComponent,
//   canActivate: [AuthGuard]
// },
{
  path: '',
  component: LayoutComponent,
  canActivate: [AuthGuard],
  children: [
    { path: 'dashboard', component: DashboardComponent },
    { path: 'users', component: UsersComponent },
    // { path: 'credit-reports', component: CreditReportsComponent }
  ]
}


];
