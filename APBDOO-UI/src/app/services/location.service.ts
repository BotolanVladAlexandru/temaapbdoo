import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Location} from "../models/Post";

@Injectable()
export class LocationService {
  private locationUrl = 'http://localhost:8080/location';
  private headers;

  constructor(private httpClient: HttpClient) {
    this.headers = new HttpHeaders({Authorization: 'Basic ' + btoa('vlad' + ':' + 'password')});
  }

  getLocations() {
    const headers = this.headers;
    return this.httpClient.get<Location[]>(this.locationUrl, {headers});
  }

}
