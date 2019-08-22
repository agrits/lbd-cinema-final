import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { UserService } from "src/app/data-services/user/user.service";
import { User } from "src/app/data-entity/user/user";
import { Router } from "@angular/router";
import { Md5 } from "ts-md5/dist/md5";

@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"]
})
export class RegisterComponent implements OnInit {
  private registerForm: FormGroup;
  constructor(private userService: UserService, private router: Router) {}
  md5 = new Md5();
  onSubmit() {
    let user: User = new User();
    user.email = this.registerForm.controls.email.value;
    user.firstName = this.registerForm.controls.firstName.value;
    user.lastName = this.registerForm.controls.lastName.value;
    user.password = this.md5
      .appendStr(this.registerForm.controls.password.value)
      .end()
      .toString();
    user.pesel = this.registerForm.controls.pesel.value;
    user.id = this.registerForm.controls.id.value;
    user.role = "USER";
    this.userService.postUser(user).subscribe(s => {
      if (s.status === 201) {
        alert(
          "Użytkownik zarejestrowany. Sprawdź swój adres e-mail w celu weryfikacji konta."
        );
        this.router.navigate(["/login"]);
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