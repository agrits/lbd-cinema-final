export interface SeatAttrs {
    id: number;
    row: number;
    column: number;
    available: boolean;
}

//Plain Old Json Object, no links!
export class Seat {
    id: number;
    row: number;
    column: number;
    available: boolean;
}
