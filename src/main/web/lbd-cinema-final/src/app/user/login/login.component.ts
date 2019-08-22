import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl } from "@angular/forms";
import { CredentialsService } from "src/app/data-services/credentials/credentials.service";

import { Md5 } from "ts-md5/dist/md5";
import { Credentials } from "src/app/data-entity/credentials/credentials";
@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {
  private email: string;
  private password: string;
  private loginForm: FormGroup;
  md5 = new Md5();
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
    this.credentialsService
      .postCredentials(new Credentials(this.email, this.md5.appendStr(this.password).end().toString()))
      .subscribe(s => {
        if (s.status == 200) {
          alert("Zalogowano.");
        } else {
          alert("Niepoprawne dane logowania. Spróbuj ponownie.");
        }
      });
  }
}
