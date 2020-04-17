import {HttpParams} from '@angular/common/http';

export class RouterUtil {
  static getUrlFromFiltersAndPagination(pagination, filter): HttpParams {
    let params = new HttpParams();
    if (pagination !== null) {
      params = params.append('page', String(pagination.pageNumber));
      params = params.append('size', String(pagination.pageSize));
    }
    return params;
  }
}
