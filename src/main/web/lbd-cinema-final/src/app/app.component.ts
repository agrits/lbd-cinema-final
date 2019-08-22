import { Component } from "@angular/core";
import { localizationService } from "./data-services/localization/localization.service";
import { Localization } from "./data-entity/localization/localization";
import { Subscription } from "rxjs";
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  cities: Localization[];
  city: Localization;
  subscribedCities: Subscription;
  subscribedDefaultCity: Subscription;
  title = "FIS-SST Cinema";
  chosenCity: string = "Gliwice";
  longtitude: string;
  lattitude: string;

  constructor(
    private localizationService: localizationService,
     private cookieService: CookieService
  ) {}

  ngOnInit() {
    this.getCities();
    this.localizationService.getPosition().then(position => {
      this.longtitude = `${position.lng}`;
      this.lattitude = `${position.lat}`;
      console.log(
        "lattitude: " + this.lattitude + " longtitude: " + this.longtitude
      );
    });

    //this.getDefaultCity(this.longtitude, this.lattitude);
  }

  cityClicked(event) {
    this.chosenCity = event.target.innerText;
  }

  getCities() {
    this.subscribedCities = this.localizationService
      .getLocalizations()
      .subscribe({
        next: data => (this.cities = data),
        error: () => alert("Could not get any Cities!")
      });
  }

  getDefaultCity(longtitude: string, lattitude: string) {
    this.subscribedDefaultCity = this.localizationService
      .getDefaultCity(longtitude, lattitude)
      .subscribe({
        next: data => (this.city = data), ///////////////////////////CHOSEN CITY <-------
        error: () => alert("Could not get any default City!")
      });
  }
}
