import { Injectable } from '@angular/core';
import { DefaultService } from '../default.service';
import { Ticket } from 'src/app/data-entity/ticket/ticket';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TicketService extends DefaultService {
  protected ticketUrl: string = "http://localhost:8080/api/reservation/tickets";

  postReservation(ticket: Ticket): Observable<Ticket>{
    return this.httpClient.post<Ticket>(this.ticketUrl, ticket);
  }

}
