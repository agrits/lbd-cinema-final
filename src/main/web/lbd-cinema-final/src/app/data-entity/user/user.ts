export interface UserAttrs {
  id: number;
  email: string;
  password: string;
  firstName: string;
  lastName: string;
  pesel: string;
  role: string;
}
export class User {
  id: number;
  email: string;
  password: string;
  firstName: string;
  lastName: string;
  pesel: string;
  role: string;
  constructor(attrs: Partial<UserAttrs> = {}) {
    this.id = attrs.id;
    this.email = attrs.email;
    this.password = attrs.password;
    this.firstName = attrs.firstName;
    this.lastName = attrs.lastName;
    this.pesel = attrs.pesel;
    this.role = attrs.role;
  }
}
