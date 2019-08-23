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

    constructor(attrs: Partial<SeatAttrs> = {}) {
        this.id = attrs.id;
        this.row = attrs.row
        this.column = attrs.column;
        this.available = attrs.available;
      }
}
