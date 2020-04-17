import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Importance} from "../models/Post";

@Injectable()
export class ImportanceService {
  private importanceUrl = 'http://localhost:8080/importance';
  private headers;

  constructor(private httpClient: HttpClient) {
    this.headers = new HttpHeaders({Authorization: 'Basic ' + btoa('vlad' + ':' + 'password')});
  }

  getImportance() {
    const headers = this.headers;
    return this.httpClient.get<Importance[]>(this.importanceUrl, {headers});
  }

}
