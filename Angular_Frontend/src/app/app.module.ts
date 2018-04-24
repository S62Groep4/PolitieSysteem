import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component.';
import { LoginComponent } from './login/login.component';
import { AuthGuardService } from './auth-guard.service';
import { AuthenticationService } from './authentication.service';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {VehicleService} from './vehicle.service';

const appRoutes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'register',
    component: RegistrationComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: '',
    component: LoginComponent
  },
  {
    path: '',
    redirectTo: '',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(
      appRoutes, {
        useHash: false
      }
    )
  ],
  providers: [
    AuthenticationService,
    AuthGuardService,
    VehicleService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
