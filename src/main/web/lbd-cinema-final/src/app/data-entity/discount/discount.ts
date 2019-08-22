export interface DiscountAttrs{
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
}
