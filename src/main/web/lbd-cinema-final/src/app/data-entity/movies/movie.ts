import { Category } from "../category/category";

export interface MovieAttrs {
  id: number;
  title: string;
  duration: number;
  rating: number;
  pegi: string;
  category: Category;
  description: string;
}
export class Movie {
  id: number;
  title: string;
  duration: number;
  rating: number;
  pegi: string;
  category: Category;
  description: string;
  constructor(attrs: Partial<MovieAttrs> = {}) {
    this.id = attrs.id;
    this.title = attrs.title;
    this.duration = attrs.duration;
    this.rating = attrs.rating;
    this.pegi = attrs.pegi;
    this.category = attrs.category;
    this.description = attrs.description;
  }
}
