export interface CategoryAttrs {
  id: number;
  name: string;
}
export class Category {
  id: number;
  name: string;
  constructor(attrs: Partial<CategoryAttrs> = {}) {
    this.id = attrs.id;
    this.name = attrs.name;
  }
}
