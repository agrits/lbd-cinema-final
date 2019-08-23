import { Injectable } from '@angular/core';
import { Show, GetShowsResponse } from 'src/app/data-entity/show/show';
import { timeout } from 'rxjs/operators';
import { map } from "rxjs/operators";
import { Observable } from 'rxjs';
import { HttpParams } from '@angular/common/http';
import { DefaultService } from '../default.service';

@Injectable({
  providedIn: 'root'
})
export class ShowService extends DefaultService{

  protected localizationUrl: string = "http://localhost:8080/api/show/shows/";

  getLocalizations(): Observable<Show[]> {
    return this.httpClient
    .get<GetShowsResponse>(this.localizationUrl).pipe(
      map(x => x._embedded.shows.map(x=> new Show(x))));
    /*.get<LocalizationAttrs[]>(this.localizationUrl)
      .pipe(
        map(data => data.map(data => new Localization(data)))
      ).pipe(timeout(20000));*/
  }
}
