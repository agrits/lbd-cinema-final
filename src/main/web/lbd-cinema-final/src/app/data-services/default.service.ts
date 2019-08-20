import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: "root"
})
export class DefaultService {
  protected apiUrl: string = "/api";
  constructor(protected httpClient: HttpClient) {}
  protected httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
  };
}
