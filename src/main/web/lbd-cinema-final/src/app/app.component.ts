import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  chosenCity: string = "Gliwice";
  cities: string[] = ["Katowice", "Gliwice", "Rzeszów", "Warszawa"];
  title = "FIS-SST Cinema";
  ngOnInit(): void {}
  cityClicked(event) {
    this.chosenCity = event.target.innerText;
  }
}
