import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  username = '';
  password = '';
  email = '';

  constructor(private authService: AuthService,private router: Router) {}

  onRegister() {
    this.authService.register(this.username, this.password, this.email)
      .subscribe({
        next: (response) => {
          console.log('Registration successful:', response);
          this.router.navigate(['/login'])
          // maybe auto-login or redirect to login page
        },
        error: (err) => {
          console.error('Registration failed:', err);
        }
      });
  }

}
