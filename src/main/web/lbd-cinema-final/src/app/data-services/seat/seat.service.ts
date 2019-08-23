import { Injectable } from '@angular/core';
import { DefaultService } from '../default.service';
import { SeatAttrs, Seat } from 'src/app/data-entity/seat/seat';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SeatService extends DefaultService{

  protected seatsUrl: string = "http://localhost:8080/api/reservation/seats-for-show";

  getSeatsByShowId(id: Number): Observable<Seat[]>{
    return this.httpClient.get<Seat[]>(this.seatsUrl + "/" + id);
  }
  
}
