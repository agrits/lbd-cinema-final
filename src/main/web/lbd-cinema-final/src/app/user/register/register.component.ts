import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl, Validators } from "@angular/forms";

@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"]
})
export class RegisterComponent implements OnInit {
  private registerForm: FormGroup;
  constructor() {}

  onSubmit() {
    console.log(this.registerForm);
  }

  ngOnInit() {
    this.initializeRegisterForm();
  }
  private initializeRegisterForm() {
    this.registerForm = new FormGroup({
      firstName: new FormControl(
        "",
        Validators.compose([
          Validators.minLength(3),
          Validators.required,
          Validators.maxLength(64)
        ])
      ),
      lastName: new FormControl(
        "",
        Validators.compose([
          Validators.minLength(3),
          Validators.required,
          Validators.maxLength(64)
        ])
      ),
      pesel: new FormControl(
        "",
        Validators.compose([
          Validators.minLength(11),
          Validators.required,
          Validators.maxLength(11)
        ])
      ),
      email: new FormControl(
        "",
        Validators.compose([Validators.required, Validators.email])
      ),
      password: new FormControl(
        "",
        Validators.compose([Validators.required, Validators.minLength(8)])
      ),
      confirmPassword: new FormControl(
        "",
        Validators.compose([Validators.required, Validators.minLength(8)])
      )
    });
  }
}
