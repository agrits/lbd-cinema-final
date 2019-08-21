export interface RoleAttrs {
  id: number;
  role: string;
}
export class Role {
  id: number;
  role: string;
  constructor(attrs: Partial<RoleAttrs> = {}) {
    this.id = attrs.id;
    this.role = attrs.role;
  }
}
