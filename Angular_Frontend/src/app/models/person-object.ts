import {Address} from './Address';

export class Person {
  public id: Number;
  public firstName: string;
  public lastName: string;
  public addressUri: Address;

  constructor(id: Number, addressUri: Address, firstName: string, lastName: string) {
    this.id = id;
    this.addressUri = addressUri;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
