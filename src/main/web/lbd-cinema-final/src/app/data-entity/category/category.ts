export interface CategoryAttrs {
  id: number;
  name: string;
  _links: {
    self: {
      href: string;
    };
    category: {
      href: string;
    };
    movies: {
      href: string;
    };
  };

}
export class Category {
  id: number;
  name: string;
  _links: {
    self: {
      href: string;
    };
    category: {
      href: string;
    };
    movies: {
      href: string;
    };
  };

  constructor(attrs: Partial<CategoryAttrs> = {}) {
    this.id = attrs.id;
    this.name = attrs.name;
    this._links = attrs._links;
  }
}
