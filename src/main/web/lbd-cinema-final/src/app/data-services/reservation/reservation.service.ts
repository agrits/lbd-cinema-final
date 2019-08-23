import { Injectable } from '@angular/core';
import { DefaultService } from '../default.service';
import { Reservation } from 'src/app/data-entity/reservation/reservation';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservationService extends DefaultService {
  protected reservationUrl: string = "http://localhost:8080/api/reservation/reservations";

  postReservation(reservation: Reservation): Observable<Reservation>{
    return this.httpClient.post<Reservation>(this.reservationUrl, reservation);
  }

  
}
