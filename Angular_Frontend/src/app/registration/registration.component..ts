import {Component, OnInit} from '@angular/core';
import {VehicleService} from '../vehicle.service';

@Component({
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
  providers: [VehicleService]
})

export class RegistrationComponent implements OnInit {
  title = 'Registrierungsseite';
  model: any = {};

  constructor(private vehicleService: VehicleService) {

  }

  ngOnInit() {

  }

  // Returning the provided hashlincenseplate as an alert, to check if the input box is not empty.
  registerLicenseplate() {
    this.vehicleService.registerLicenseplate(this.model.hashedlicenseplate)
      .subscribe(vehicle => {
        alert(vehicle.hashedlicenseplate);
      });
  }
}
