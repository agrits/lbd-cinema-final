import { Injectable } from "@angular/core";
import { DefaultService } from "../default.service";
import { Localization, LocalizationAttrs } from "src/app/data-entity/localization/localization";
import { map } from "rxjs/operators";
import { Observable } from 'rxjs';
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

  getDefaultCity(): Observable<Localization> {
    return this.httpClient.get<Localization>(this.apiUrl + this.localizationUrl);
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
