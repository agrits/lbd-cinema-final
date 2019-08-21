import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { UserService } from "src/app/data-services/user/user.service";
import { User } from "src/app/data-entity/user/user";

@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"]
})
export class RegisterComponent implements OnInit {
  private registerForm: FormGroup;
  constructor(private userService: UserService) {}

  onSubmit() {
    let user: User = new User();
    user.email = this.registerForm.controls.email.value;
    user.firstName = this.registerForm.controls.firstName.value;
    user.lastName = this.registerForm.controls.lastName.value;
    user.password = this.registerForm.controls.password.value;
    user.pesel = this.registerForm.controls.pesel.value;
    user.id = this.registerForm.controls.id.value;
    user.role = "USER";
    this.userService.postUser(user).subscribe(s => {
      if (s.status === 201) {
        alert(
          "Użytkownik zarejestrowany. Sprawdź swój adres e-mail w celu weryfikacji konta."
        );
      } else if (s.status === 400) {
        alert("Użytkownik już istnieje. Wybierz inny adres e-mail.");
      } else {
        alert("Błąd podczas tworzenia użytkownika.");
      }
    });
    this.registerForm.reset();
  }

  ngOnInit() {
    this.initializeRegisterForm();
  }
  private initializeRegisterForm() {
    this.registerForm = new FormGroup({
      id: new FormControl(),
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
