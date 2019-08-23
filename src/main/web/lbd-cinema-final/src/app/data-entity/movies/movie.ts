import { Category } from '../category/category';
import { LinkHelper } from 'src/app/data-services/link-helper';

export interface GetMoviesResponse {
  _embedded: {
    movies: MovieAttrs[];
  };
}

export interface MovieAttrs {
  title: string;
  duration: number;
  rating: number;
  pegi: string;
  description: string;
  _links: {
    self: {
      href: string;
    };
    movie: {
      href: string;
    };
    category: {
      href: string;
    };
  };
}


export class Movie {
  id: Number;
  title: string;
  duration: number;
  rating: number;
  pegi: string;
  description: string;
  category: Category;
  _links: {
    self: {
      href: string;
    };
    movie: {
      href: string;
    };
    category: {
      href: string;
    };
  };


  constructor(
    attrs: Partial<MovieAttrs>) {
    this.title = attrs.title;
    this.duration = attrs.duration;
    this.rating = attrs.rating;
    this.pegi = attrs.pegi;
    this._links = attrs._links;
    this.description = attrs.description;
    this.id = LinkHelper.getIdFromSelfHref(this._links.self.href);
  }
}
