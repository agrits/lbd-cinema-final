export interface GetReservationsResponse {
    _embedded: {
      reservations: ReservationAttrs[];
    };
  }

export interface ReservationAttrs {
    userId: number;
    showId: number;

    //be aware of date-format
    //may be change type to string and then parse to date
    time: Date;

    _links: {
        self: {
            href: string;
        };
        reservation: {
            href: string;
        };
        tickets: {
            href: string;
        };
    };
}

export class Reservation {
    userId: number;
    showId: number;
    //be aware of date-format
    //may be change type to string and then parse to date
    time: Date;

    _links: {
        self: {
            href: string;
        };
        reservation: {
            href: string;
        };
        tickets: {
            href: string;
        };
    };

    constructor(attrs: Partial<ReservationAttrs>) {
        this.userId = attrs.userId;
        this.showId = attrs.showId;
        this.time = attrs.time;
        this._links = attrs._links;
      }

}
