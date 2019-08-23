import { Injectable } from '@angular/core';
import { DiscounResponseAttrs, Discount } from '../../data-entity/discount/discount';
import { Observable } from 'rxjs';
import { map } from "rxjs/operators";
import { DefaultService } from '../default.service';

@Injectable({
  providedIn: 'root'
})
export class DiscountService extends DefaultService{

  getDiscounts(): Observable<Discount[]> {
    return this.httpClient
      .get<DiscounResponseAttrs>("http://localhost:8080/api/reservation/discounts").pipe(
        map(embedded => embedded._embedded.movies.map(discountAttrs => new Discount(discountAttrs)))
      )
  }
}
