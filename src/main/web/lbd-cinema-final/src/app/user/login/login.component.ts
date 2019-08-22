import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl } from "@angular/forms";
import { CredentialsService } from "src/app/data-services/credentials/credentials.service";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {
  private email: string;
  private password: string;
  private loginForm: FormGroup;
  constructor(private credentialsService: CredentialsService) {}
  onSubmit() {
    this.checkCredentials();
    this.loginForm.reset();
  }

  ngOnInit() {
    this.initializeLoginForm();
  }
  private initializeLoginForm() {
    this.loginForm = new FormGroup({
      email: new FormControl(),
      password: new FormControl()
    });
  }
  private checkCredentials() {
    if (this.credentialsService.checkCredentials(this.email, this.password)) {
      // Credentials correct, user logged in.
    } else {
      alert("Niepoprawne dane logowania. Spróbuj ponownie.");
    }
  }
}
