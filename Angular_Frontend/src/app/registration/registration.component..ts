import {Component, OnInit} from '@angular/core';
import {VehicleService} from '../vehicle.service';
import {Vehicle} from '../models/vehicle-object';
import {SubInvoice} from '../models/subinvoice-object';
import {Journey} from '../models/journey-object';
import {Translocation} from '../models/translocation-object';
import {Person} from '../models/person-object';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
  providers: [VehicleService]
})

export class RegistrationComponent implements OnInit {
  // Google maps values
  lat = 51.6;
  lng = 7.80;
  locationChosen = false;

  title = 'Registrierungsseite';
  model: any = {};
  vehicles: Vehicle[];
  searchVehicle: Vehicle[];
  subInvoices: SubInvoice[];
  journeys: Journey[];
  translocations: Translocation[];
  person: Person;

  constructor(private vehicleService: VehicleService, public sanitizer: DomSanitizer) {
    this.getVehicles();
  }

  onChoseLocation(event) {
    this.lat = event.coords.lat;
    this.lng = event.coords.lng;
    //this.locationChosen = true;
  }

  ngOnInit() {
  }

  getVehicles() {
    this.vehicleService.getVehicles().subscribe(vehicles => this.vehicles = vehicles);
  }

  getSubInvoices(uri: string) {
    this.vehicleService.getSubInvoice(uri).subscribe(subInvoices => this.subInvoices = subInvoices);
  }

  getJourneys(uri: string) {
    this.vehicleService.getJourneys(uri).subscribe(journeys => this.journeys = journeys);
  }

  getTranslocations(uri: string) {
    this.vehicleService.getTranslocations(uri).subscribe(translocations => this.translocations = translocations);
  }

  getPersonByLicenceplate(unhashedLicenceplate: String) {
    this.vehicleService.getPersonByLicenceplate(unhashedLicenceplate).subscribe(person => this.person = person);
  }

  insertVehicle() {
    this.vehicleService.insertVehicle(this.model.hashedLicensePlate)
      .subscribe(vehicle => {
        this.reloadPage();
      });
  }

  searchCarByLicensePlate(licencePlate: String) {
    if (licencePlate.length > 2) {
      this.vehicleService.searchCarByLicensePlate(licencePlate).subscribe(vehicle => this.searchVehicle = vehicle);
    } else {
      // Do nothing
    }
  }

  reloadPage() {
    location.reload();
  }
}
