import { Injectable } from '@angular/core';
import { AuthenticationService } from './service/authentication.service';
import { Router } from '@angular/router';

@Injectable()
export class AuthGuardService {

  constructor(public auth : AuthenticationService, public router : Router) { }

  canActivate(): boolean{
    if(!this.auth.isAuthenticated()){
      this.router.navigate(['']);
      return false;
    }
    return true;
  }
}
