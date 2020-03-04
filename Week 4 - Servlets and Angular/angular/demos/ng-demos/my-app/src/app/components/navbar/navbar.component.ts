import { Component, OnDestroy } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { Principal } from 'src/app/models/principal';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnDestroy {

  currentUser: Principal;
  currentUserSub: Subscription;

  constructor(private authService: AuthService, private router: Router) {
    this.currentUserSub = this.authService.currentUser$.subscribe(user => {
      this.currentUser = user;
    });
  }

  ngOnDestroy() {
    this.currentUserSub.unsubscribe();
  }

  logout = () => {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

}
