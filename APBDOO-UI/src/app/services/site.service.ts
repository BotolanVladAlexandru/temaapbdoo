import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Location, Site} from "../models/Post";

@Injectable()
export class SiteService {
  private siteUrl = 'http://localhost:8080/site';
  private headers;

  constructor(private httpClient: HttpClient) {
    this.headers = new HttpHeaders({Authorization: 'Basic ' + btoa('vlad' + ':' + 'password')});
  }

  getSites() {
    const headers = this.headers;
    return this.httpClient.get<Site[]>(this.siteUrl, {headers});
  }

}
