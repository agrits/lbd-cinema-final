export interface DiscounResponseAttrs {
    _embedded: {
        movies: DiscountAttrs[];
    };
}


export interface DiscountAttrs {
    name: string;
    amount: number;
    _links: {
        self: {
            href: string;
        };
        discount: {
            href: string;
        },
        tickets: {
            href: string;
        }
    }
}

export class Discount {
    name: string;
    amount: number;
    _links: {
        self: {
            href: string;
        };
        discount: {
            href: string;
        },
        tickets: {
            href: string;
        }
    }



    constructor(attrs: Partial<DiscountAttrs>) {
        this.name = attrs.name;
        this.amount = attrs.amount;
        this._links = attrs._links;        
    }

}