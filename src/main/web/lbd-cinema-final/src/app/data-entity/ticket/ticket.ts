export interface GetTicketsResponse {
    _embedded: {
      tickets: TicketAttrs[];
    };
  }


export interface TicketAttrs {
    seatId: number;
    _links: {
        self: {
            href: string;
        };
        ticket: {
            href: string;
        };
        discount: {
            href: string;
        };
        reservation: {
            href: string;
        };
    };
}

export class Ticket {
    seatId: number;
    _links: {
        self: {
            href: string;
        };
        ticket: {
            href: string;
        };
        discount: {
            href: string;
        };
        reservation: {
            href: string;
        };
    };

    constructor(attrs: Partial<TicketAttrs>) {
        this.seatId = attrs.seatId;
        this._links = attrs._links;
      }
}
