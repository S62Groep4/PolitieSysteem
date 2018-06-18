import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {VehicleEuropol} from '../models/VehicleEuropol';
import {Observable} from 'rxjs/Observable';
import {environment} from '../../environments/environment';

@Injectable()
export class EuropolService {
  URI_EUROPOL = environment.API_POLITIE_URL;

  constructor(private http: HttpClient) {

  }

  getStolenVehicles(): Observable<VehicleEuropol[]> {
    return this.http.get(this.URI_EUROPOL + 'stolenvehicles')
      .map(response => response as VehicleEuropol[]);
  }
}
