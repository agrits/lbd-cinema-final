export interface LocalizationAttrs {
    id: number;
    city: string;
    address: string;
    lattitude: number;
    longtitude: number;
  }
  export class Localization {
    id: number;
    city: string;
    address: string;
    lattitude: number;
    longtitude: number;

    description: string;
    constructor(attrs: Partial<LocalizationAttrs> = {}) {
      this.id = attrs.id;
      this.city = attrs.city
      this.address = attrs.address;
      this.lattitude = attrs.lattitude;
      this.longtitude = attrs.longtitude;
    }
  }