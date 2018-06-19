import {Translocation} from './translocation-object';

export class Journey {
  public id: Number;
  public translocationUri: Translocation[];

  constructor(id: Number, translocationUri: Translocation[]) {
    this.id = id;
    this.translocationUri = translocationUri;
  }
}
