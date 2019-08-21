import { Injectable } from "@angular/core";
import { DefaultService } from "../default.service";
import { Localization, LocalizationAttrs } from "src/app/data-entity/localization/localization";
import { map } from "rxjs/operators";
import { Observable } from 'rxjs';
import { HttpParams } from '@angular/common/http';
@Injectable({
  providedIn: "root"
})
export class localizationService extends DefaultService {
  
  protected localizationUrl: string = "/locations"; //"localization";

  getLocalizations(): Observable<Localization[]> {
    return this.httpClient
      .get<LocalizationAttrs[]>(this.apiUrl + this.localizationUrl)
      .pipe(
        map(data => data.map(data => new Localization(data)))
      );
  }

  updateLocalization(localization: Localization): Observable<LocalizationAttrs>{
      return this.httpClient.put<LocalizationAttrs>(this.apiUrl + this.localizationUrl, localization);
  }

  getDefaultCity(longitude: string, lattitude: string): Observable<Localization> {
    let params = new HttpParams().set("longitude", longitude).set("lattitude", lattitude);
    return this.httpClient.get<Localization>(this.apiUrl + this.localizationUrl + "/default", {params: params});
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
