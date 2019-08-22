import { Injectable } from "@angular/core";
import { User } from "src/app/data-entity/user/user";
import { Observable } from "rxjs";
import { DefaultService } from "../default.service";

@Injectable({
  providedIn: "root"
})
export class UserService extends DefaultService {
  protected userUrl: string = "http://localhost:8080/api/user/register";
  postUser(user: User): Observable<any> {
    return this.httpClient.post<User>(this.userUrl, user, {
      observe: "response"
    });
  }
}
