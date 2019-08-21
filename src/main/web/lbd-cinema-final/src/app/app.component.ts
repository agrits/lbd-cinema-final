import { Component } from "@angular/core";
import { localizationService } from './data-services/localization/localization.service';
import { Localization } from './data-entity/localization/localization';
import { Subscription } from 'rxjs';

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
  longitude: string;
  latitude: string;

  constructor(private localizationService: localizationService){}
  
  ngOnInit(){
    this.getCities();
    this.localizationService.getPosition().then(position => {
      this.longitude = `${position.lng}`;
      this.latitude = `${position.lat}`;
      console.log("latitude: " + this.latitude + " longitude: " + this.longitude);
    });

    //this.getDefaultCity(this.longitude, this.latitude);
  }

  cityClicked(event) {
    this.chosenCity = event.target.innerText;
  }

  getCities(){
    this.subscribedCities = this.localizationService.getLocalizations().subscribe({
      next: (data) => this.cities = data,
      error: () => alert('Could not get any Cities!')
    });
  }

  getDefaultCity(longitude: string, latitude: string){
    this.subscribedDefaultCity = this.localizationService.getDefaultCity(longitude, latitude).subscribe({
      next: (data) => this.city = data, ///////////////////////////CHOSEN CITY <-------
      error: () => alert('Could not get any default City!')
    });
  }


}
