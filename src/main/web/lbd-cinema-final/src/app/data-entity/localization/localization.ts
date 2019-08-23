import { LinkHelper } from 'src/app/data-services/link-helper';

export interface GetLocalizationsResponse {
  _embedded: {
    locations: LocalizationAttrs[];
  };
}

export interface LocalizationAttrs {
  city: string;
  address: string;
  latitude: number;
  longtitude: number;
  _links: {
    self: {
      href: string;
    };
    location: {
      href: string;
    };
    cinema: {
      href: string;
    };
  }
}
export class Localization {
  id: Number;
  city: string;
  address: string;
  latitude: number;
  longtitude: number;
  _links: {
    self: {
      href: string;
    };
    location: {
      href: string;
    };
    cinema: {
      href: string;
    };
  }

  constructor(attrs: Partial<LocalizationAttrs>) {
    this.id = LinkHelper.getIdFromSelfHref(attrs._links.self.href);
    this.city = attrs.city
    this.address = attrs.address;
    this.latitude = attrs.latitude;
    this.longtitude = attrs.longtitude;
  }
}