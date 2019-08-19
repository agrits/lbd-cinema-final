import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { RouterModule } from "@angular/router";
import { RegisterComponent } from "./user/register/register.component";
import { UserModule } from "./user/user.module";
import { LoginComponent } from "./user/login/login.component";

@NgModule({
  declarations: [AppComponent],
  imports: [
    UserModule,
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot([
      { path: "register", component: RegisterComponent },
      { path: "login", component: LoginComponent }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
