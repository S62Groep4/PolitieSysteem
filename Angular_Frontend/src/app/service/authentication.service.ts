import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {UserLogin} from '../user-login';
import {tokenNotExpired} from 'angular2-jwt/angular2-jwt';
import {Observable} from 'rxjs/Observable';
import {environment} from '../../environments/environment';

@Injectable()
export class AuthenticationService {
  URI_EUROPOL = environment.API_POLITIE_URL;
  httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'})};

  constructor(private http: HttpClient) {
  }

  public login(email: string, password: string): Observable<any> {
    const user = new UserLogin(email, password);
    console.log(user.email);
    return this.http.post(this.URI_EUROPOL + 'login', user, {
      headers: this.httpOptions.headers,
      observe: 'response'
    });
  }

  public isAuthenticated(): boolean {
    const token = this.getToken();
    return tokenNotExpired(null, token);
  }

  public getToken(): string {
    return localStorage.getItem('token');
  }

  public removeToken() {
    localStorage.removeItem('token');
  }
}
