import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username = '';
  password = '';
  errorMessage = '';

  constructor(private authService: AuthService,private router: Router) {}

  onLogin() {
    this.authService.login(this.username, this.password).subscribe({
      next: (res) => {
        this.authService.saveToken(res.token, res.tokenType);
        alert('Login successful!');
        this.router.navigate(['/']);
        // navigate to dashboard or courses page
      },
      error: () => {
        this.errorMessage = 'Invalid credentials';
      }
    });
  }

}
