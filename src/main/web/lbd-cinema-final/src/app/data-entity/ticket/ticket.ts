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
}
