import {Component, OnInit} from '@angular/core';
import {VehicleService} from '../vehicle.service';
import {Vehicle} from '../models/vehicleObject';
import {Observable} from 'rxjs/Observable';

@Component({
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
  providers: [VehicleService]
})

export class RegistrationComponent implements OnInit {
  title = 'Registrierungsseite';
  model: any = {};
  observableVehicles: Observable<Vehicle[]>;
  vehicles: Vehicle[];
  observableSearchVehicle: Observable<Vehicle[]>;
  searchVehicle: Vehicle[];

  constructor(private vehicleService: VehicleService) {
    this.getVehicles();
  }

  ngOnInit() {

  }

  getVehicles() {
    this.observableVehicles = this.vehicleService.getVehicles();
    this.observableVehicles.subscribe(vehicles => this.vehicles = vehicles);
  }

  insertVehicle() {
    this.vehicleService.insertVehicle(this.model.licencePlate)
      .subscribe(vehicle => {
        this.reloadPage();
      });
  }

  searchCarByLicensePlate(licencePlate: String) {
    this.observableSearchVehicle = this.vehicleService.searchCarByLicensePlate(licencePlate);
    this.observableSearchVehicle.subscribe(vehicle => this.searchVehicle = vehicle);
  }

  reloadPage() {
    location.reload();
  }
}
