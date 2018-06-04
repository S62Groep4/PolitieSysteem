import {Injectable} from '@angular/core';
import {Translocation} from './models/translocation-object';
import {Subject} from 'rxjs/Subject';
import {HttpClient} from '@angular/common/http';
import {WebsocketService} from './websocket.service';

@Injectable()
export class TranslocationService {

  public transLocationsLive: Subject<Translocation>;

  constructor(private http: HttpClient, private websocketService: WebsocketService) {
    this.transLocationsLive = <Subject<Translocation>>websocketService
      .connect('ws://localhost:8080/[administration-endpoint-needed]')
      .map((response: MessageEvent): Translocation => {
        const data = JSON.parse(response.data);
        return data;
      });
  }
}
