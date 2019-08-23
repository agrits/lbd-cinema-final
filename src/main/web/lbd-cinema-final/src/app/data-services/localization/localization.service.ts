import { Injectable } from "@angular/core";
import { DefaultService } from "../default.service";
import { Localization, LocalizationAttrs, GetLocalizationsResponse } from "src/app/data-entity/localization/localization";
import { map } from "rxjs/operators";
import { Observable } from 'rxjs';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: "root"
})
export class localizationService extends DefaultService {

  protected localizationUrl: string = "http://localhost:8080/api/cinema/locations";

  getLocalizations(): Observable<Localization[]> {
    return this.httpClient
      .get<GetLocalizationsResponse>(this.localizationUrl)
      .pipe(
        map(embedded => embedded._embedded.locations.map(attrs => new Localization(attrs)))
      );
  }

  getDefaultCity(longitude: string, latitude: string): Observable<Localization> {
    let params = new HttpParams().set("longitude", longitude).set("latitude", latitude);

    return this.httpClient.get<LocalizationAttrs>(this.localizationUrl + "/default", { params: params })
      .pipe(map(attrs => new Localization(attrs)));
  }

  getPosition(): Promise<any> {
    return new Promise((resolve, reject) => {

      navigator.geolocation.getCurrentPosition(resp => {

        resolve({ lng: resp.coords.longitude, lat: resp.coords.latitude });
      },
        err => {
          reject(err);
        });
    });

  }

}
