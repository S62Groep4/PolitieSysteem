import {Component, OnInit} from '@angular/core';
import {VehicleService} from '../vehicle.service';
import {Vehicle} from '../models/vehicle-object';
import {Observable} from 'rxjs/Observable';
import {SubInvoice} from '../models/subinvoice-object';
import {Journey} from "../models/journey-object";
import {Translocation} from "../models/translocation-object";

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
  observableJourneys: Observable<Journey[]>;
  journeys: Journey[];
  observableTranslocations: Observable<Translocation[]>;
  translocations: Translocation[];

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

  getJourneys(uri: string) {
    this.observableJourneys = this.vehicleService.getJourneys(uri);
    this.observableJourneys.subscribe(journeys => this.journeys = journeys);
  }

  getTranslocations(uri: string) {
    this.observableTranslocations = this.vehicleService.getTranslocations(uri);
    this.observableTranslocations.subscribe(translocations => this.translocations = translocations);
  }

  insertVehicle() {
    this.vehicleService.insertVehicle(this.model.hashedLicensePlate)
      .subscribe(vehicle => {
        this.reloadPage();
      });
  }

  searchCarByLicensePlate(licencePlate: String) {
    if (licencePlate.length > 2) {
      this.observableSearchVehicle = this.vehicleService.searchCarByLicensePlate(licencePlate);
      this.observableSearchVehicle.subscribe(vehicle => this.searchVehicle = vehicle);
    } else {
      // Do nothing
    }
  }

  reloadPage() {
    location.reload();
  }
}
