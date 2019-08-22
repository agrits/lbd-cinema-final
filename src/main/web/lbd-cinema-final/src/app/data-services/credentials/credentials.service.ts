import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Credentials } from "src/app/data-entity/credentials/credentials";
import { DefaultService } from "../default.service";
@Injectable({
  providedIn: "root"
})
export class CredentialsService extends DefaultService {
  credentialsUrl: string = "/credentials";

  postCredentials(credentials: Credentials): Observable<any> {
    return this.httpClient.post<Credentials>(
      this.apiUrl + this.credentialsUrl,
      credentials,
      {
        observe: "response"
      }
    );
  }
  public checkCredentials(email: String, password: String): Boolean {
    let areCredentialsCorrect: Boolean;
    this.postCredentials(new Credentials(email, password)).subscribe(s => {
      if (s.status === 200) {
        areCredentialsCorrect = true;
      } else {
        areCredentialsCorrect = false;
      }
    });
    return areCredentialsCorrect;
  }
}
