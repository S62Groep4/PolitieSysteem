import {Injectable} from '@angular/core';
import {Translocation} from '../models/translocation-object';
import {Subject} from 'rxjs/Subject';
import {HttpClient} from '@angular/common/http';
import {WebsocketService} from './websocket.service';

@Injectable()
export class TranslocationService {

  public transLocationsLive: Subject<Translocation>;

  constructor(private http: HttpClient, private websocketService: WebsocketService) {
  }

  public CreateWebSocket(vehicleId: String) {

    this.transLocationsLive = <Subject<Translocation>> this.websocketService
      .connect('ws://192.168.24.91:8282/Politie/serverwsendpoint/' + vehicleId )
      .map((response: MessageEvent): Translocation => {
        const data = JSON.parse(response.data);
        return data;
      });
  }
}
