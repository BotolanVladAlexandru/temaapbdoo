import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {PaginationFilter} from "../models/PaginationFilter";
import {RouterUtil} from "../utils/RouterUtil";
import {Post} from "../models/Post";
import {GenericListModel} from "../models/generic-list-model";
import {Observable} from "rxjs";

@Injectable()
export class PostService {
  private postUrl = 'http://localhost:8080/post';
  private headers;

  constructor(private httpClient: HttpClient) {
    this.headers = new HttpHeaders({Authorization: 'Basic ' + btoa('vlad' + ':' + 'password')});
  }

  getPosts(pagination: PaginationFilter, filter, sort: string = '') {
    const headers = this.headers;
    return this.httpClient.get<GenericListModel<Post>>(this.postUrl,
      {
        params: {
          ...RouterUtil.getUrlFromFiltersAndPagination(pagination, filter),
          sort: sort,
          ...filter
        }, headers
      });
  }


  deletePost(id: string) {
    const headers = this.headers;
    return this.httpClient.delete(this.postUrl + '/' + id, {headers});
  }

  createPost(post: Post): Observable<any> {
    post.tagModel = {name: post.tag};
    const headers = this.headers;
    return this.httpClient.post<Post>(this.postUrl, post, {headers});
  }

  updatePost(id: string, post: Post): Observable<any> {
    post.tagModel = {name: post.tag};
    const headers = this.headers;
    return this.httpClient.put<Post>(this.postUrl + '/' + id, post, {headers});
  }

  getPost(id: string) {
    const headers = this.headers;
    return this.httpClient.get<Post>(this.postUrl + '/' + id, {headers});
  }

}
