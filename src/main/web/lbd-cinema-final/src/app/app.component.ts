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

  constructor(private localizationService: localizationService){}
  
  ngOnInit(){
    this.getCities();
    this.getDefaultCity();
    console.log(this.localizationService.getPosition());
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

  getDefaultCity(){
    this.subscribedDefaultCity = this.localizationService.getDefaultCity().subscribe({
      next: (data) => this.city = data,
      error: () => alert('Could not get any default City!')
    });
  }

  updateCity(){

  }

  displayPosition(){
    console.log(this.localizationService.getPosition());
  }

}
