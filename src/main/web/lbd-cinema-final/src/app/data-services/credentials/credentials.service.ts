import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Credentials } from "src/app/data-entity/credentials/credentials";
import { DefaultService } from "../default.service";
@Injectable({
  providedIn: "root"
})
export class CredentialsService extends DefaultService {
  credentialsUrl: string = "http://localhost:8080/api/user/login";

  postCredentials(credentials: Credentials): Observable<any> {
    return this.httpClient.post<Credentials>(this.credentialsUrl, credentials, {
      observe: "response"
    });
  }
}
