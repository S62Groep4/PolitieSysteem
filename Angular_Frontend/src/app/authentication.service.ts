import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { UserLogin } from './user-login';
import { tokenNotExpired } from 'angular2-jwt';

@Injectable()
export class AuthenticationService {

  httpOptions = {headers: new HttpHeaders({'Content-Type' : 'application/json'})};

  constructor(private http : HttpClient) { }

  public login(email : string, password : string){
    const user = new UserLogin(email, password);

    return this.http.post("http://localhost:8080/PolitieSysteem/api/login", user, {headers: this.httpOptions.headers, observe : 'response'});
  }

  public isAuthenticated() : boolean{
   const token = this.getToken();
   return tokenNotExpired(null, token); 
  }

  public getToken() : string{
    return localStorage.getItem('token')
  }

  public removeToken(){
    localStorage.removeItem('token');
  }
}
