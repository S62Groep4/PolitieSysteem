import {Component, OnInit} from '@angular/core';
import {VehicleService} from '../vehicle.service';
import {Vehicle} from '../models/vehicle-object';
import {Observable} from 'rxjs/Observable';
import {SubInvoice} from '../models/subinvoice-object';

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
  observableInvoices: Observable<SubInvoice[]>;
  subInvoices: SubInvoice[];

  constructor(private vehicleService: VehicleService) {
    this.getVehicles();
  }

  ngOnInit() {

  }

  getVehicles() {
    this.observableVehicles = this.vehicleService.getVehicles();
    this.observableVehicles.subscribe(vehicles => this.vehicles = vehicles);
  }

  getSubInvoices(uri: string) {
    this.observableInvoices = this.vehicleService.getSubInvoice(uri);
    this.observableInvoices.subscribe(subInvoices => this.subInvoices = subInvoices);
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
