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
import { MoviesComponent } from './cinema/movies/movies.component';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    UserModule,
    CinemaModule,
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
