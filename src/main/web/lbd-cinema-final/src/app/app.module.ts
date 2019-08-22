import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { RouterModule } from "@angular/router";
import { RegisterComponent } from "./user/register/register.component";
import { UserModule } from "./user/user.module";
import { LoginComponent } from "./user/login/login.component";
import { CinemaModule } from "./cinema/cinema.module";
import { RepertoireComponent } from "./cinema/repertoire/repertoire.component";
import { MoviesComponent } from "./cinema/movies/movies.component";
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    UserModule,
    CinemaModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: "register", component: RegisterComponent },
      { path: "login", component: LoginComponent },
      { path: "movies", component: MoviesComponent },
      { path: "repertoire", component: RepertoireComponent }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
