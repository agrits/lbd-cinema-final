import { Component } from "@angular/core";
import { localizationService } from "./data-services/localization/localization.service";
import { Localization } from "./data-entity/localization/localization";
import { Subscription } from "rxjs";
import { CookieService } from "ngx-cookie-service";

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

  userName: string;
  constructor(
    private localizationService: localizationService,
    private cookieService: CookieService
  ) {}

  ngOnInit() {
    this.getCities();
    //;
    this.setUsername();
  }
  private setUsername() {
    this.userName = JSON.parse(
      this.cookieService.get("userCookie")
    ).body.firstName;
  }
  private logoutUser() {
    this.cookieService.delete("userCookie");
  }
  private cityClicked(event) {
    this.chosenCity = event.target.innerText;
  }
  setUpChosenCity() {
    let longtitude: string;
    let lattitude: string;
    this.localizationService.getPosition().then(position => {
      longtitude = `${position.lng}`;
      lattitude = `${position.lat}`;

      console.log(longtitude + " " + lattitude);
      this.getDefaultCity(longtitude, lattitude);
      if (this.city) {
        this.chosenCity = this.city.city;
      }
      sessionStorage.setItem("chosenCity", JSON.stringify(this.chosenCity));
    });
  }
  getCities() {
    this.subscribedCities = this.localizationService
      .getLocalizations()
      .subscribe({
        next: data => (this.cities = data),
        error: () => alert("Could not get any Cities!"),
        complete: () => this.setUpChosenCity()
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
