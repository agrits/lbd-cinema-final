import { Injectable } from "@angular/core";
import { DefaultService } from "../default.service";
import { Localization, LocalizationAttrs } from "src/app/data-entity/localization/localization";
import { map } from "rxjs/operators";
import { Observable } from 'rxjs';
import { HttpParams } from '@angular/common/http';
import { timeout } from 'rxjs/operators';

@Injectable({
  providedIn: "root"
})
export class localizationService extends DefaultService {
  
  protected localizationUrl: string = "http://localhost:8080/api/cinema/locations";

  getLocalizations(): Observable<Localization[]> {
    return this.httpClient
    .get<Localization[]>(this.localizationUrl).pipe(timeout(20000));
    /*.get<LocalizationAttrs[]>(this.localizationUrl)
      .pipe(
        map(data => data.map(data => new Localization(data)))
      ).pipe(timeout(20000));*/
  }

  updateLocalization(localization: Localization): Observable<LocalizationAttrs>{
      return this.httpClient.put<LocalizationAttrs>(this.localizationUrl, localization);
  }

  getDefaultCity(longitude: string, latitude: string): Observable<Localization> {
    let params = new HttpParams().set("longitude", longitude).set("latitude", latitude);
    return this.httpClient.get<Localization>(this.localizationUrl + "/default", {params: params}).pipe(timeout(90000));
  }

  getPosition(): Promise<any>
  {
    return new Promise((resolve, reject) => {

      navigator.geolocation.getCurrentPosition(resp => {

          resolve({lng: resp.coords.longitude, lat: resp.coords.latitude});
        },
        err => {
          reject(err);
        });
    });

  }

}
