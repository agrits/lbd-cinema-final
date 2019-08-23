export interface SeatAttrs {
    id: Number;
    row: number;
    column: number;
    available: boolean;
}

//Plain Old Json Object, no links!
export class Seat {
    id: Number;
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
