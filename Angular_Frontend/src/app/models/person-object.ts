import {Vehicle} from './vehicle-object';

export class Person {
  public id: Number;
  public firstName: String;
  public lastName: String;
  public vehicles: Vehicle[];

  constructor(id: Number, firstName: String, lastName: String){//}, vehicles: Vehicle[]) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    //this.vehicles = vehicles;
  }
}
