import { Injectable } from "@angular/core";
import { DefaultService } from "../default.service";
import { Category, CategoryAttrs } from "src/app/data-entity/category/category";
import { map } from "rxjs/operators";
import { Observable } from 'rxjs';
@Injectable({
  providedIn: "root"
})
export class CategoryService extends DefaultService {
  protected categoriesUrl: string = "/categories";

  getCategories(): Observable<Category[]> {
    return this.httpClient
      .get<CategoryAttrs[]>(this.apiUrl + this.categoriesUrl)
      .pipe(
        map(data => data.map(categoryAttrs => new Category(categoryAttrs)))
      );
  }

  getCategory(href: string): Observable<Category> {
    return this.httpClient
      .get<CategoryAttrs>(href)
      .pipe(
        map(data => new Category(data))
      );
  }


}
