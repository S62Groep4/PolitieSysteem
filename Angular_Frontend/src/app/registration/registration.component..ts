import {Component, OnInit} from '@angular/core';
import {VehicleService} from '../vehicle.service';
import {Vehicle} from '../models/vehicle-object';
import {SubInvoice} from '../models/subinvoice-object';
import {Journey} from '../models/journey-object';
import {Translocation} from '../models/translocation-object';
import {Person} from '../models/person-object';
import {WebsocketService} from '../websocket.service';
import {TranslocationService} from '../translocation.service';

@Component({
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
  providers: [VehicleService, WebsocketService, TranslocationService]
})

export class RegistrationComponent implements OnInit {
  // Google maps values
  lat = 51.690989;
  lng = 7.809564;
  selectCarHistroy = false;
  selectCarLive = false;

  title = 'Registrierungsseite';
  model: any = {};
  vehicles: Vehicle[];
  searchVehicle: Vehicle[];
  subInvoices: SubInvoice[];
  journeys: Journey[];
  translocations: Translocation[];
  transLocationsLive: Translocation[];
  person: Person;

  constructor(private vehicleService: VehicleService, private translocationService: TranslocationService) {
    this.getVehicles();
  }

  onChoseLocation(event) {
    this.lat = event.coords.lat;
    this.lng = event.coords.lng;
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

  selectCarHistroyOn() {
    this.selectCarHistroy = true;
    this.selectCarLive = false;
  }

  selectCarLiveOn() {
    this.selectCarLive = true;
    this.selectCarHistroy = false;
    this.getTranslocationsLive(this.translocationService);
  }

  getTranslocationsLive(translocationService: TranslocationService) {
    console.log('Retrieving live locations...')
    translocationService.transLocationsLive.subscribe(msg => {
      console.log('Response from websocket: ' + JSON.stringify(msg));
      this.transLocationsLive.unshift(msg);
    });
  }
}
