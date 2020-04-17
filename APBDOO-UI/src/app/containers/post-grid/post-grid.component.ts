import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {AuthService, PostService} from "../../services";
import {PaginationFilter} from "../../models/PaginationFilter";
import {Router} from "@angular/router";
import {MatSort} from "@angular/material/sort";

@Component({
  selector: 'page-gird',
  templateUrl: './post-grid.component.html',
  styleUrls: ['./post-grid.component.scss']
})
export class PostGridComponent implements OnInit {
  displayedColumns: string[] = ['title', 'text', 'tag', 'location', 'categories', 'sites','importance', 'button'];
  dataSource;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  length = 5;
  pageIndex = 0;
  pageSize = 5;
  pageEvent: PageEvent;
  sortFilter = '';
  titleValue = '';

  constructor(private postService: PostService,
              private loginService: AuthService,
              private router: Router) {
  }

  titleFilterChanged() {
    const paginationFiler: PaginationFilter =
      {
        pageNumber: this.pageIndex,
        pageSize: this.pageSize,
      };

    this.postService.getPosts(paginationFiler, {title: this.titleValue}, this.sortFilter).subscribe(
      response => {
        response.items.map(value => {
          value.categoryNames =
            value.categoryModels.map(category => category.name).join(', ');
          value.siteNames =
            value.siteModels.map(site => site.name).join(', ');
          return value;
        });
        this.dataSource = response.items;
        this.dataSource.sort = this.sort;
        this.length = response.totalCount;
      }
    );
  }

  ngOnInit(): void {
    if (!this.loginService.isUserLoggedIn()) {
      this.router.navigate(['login']);
    }

    this.getPages(this.getPagination());
  }

  private getPagination() {
    return {pageIndex: this.pageIndex, pageSize: this.pageSize, length: this.length};
  }

  deletePost(id: string) {
    this.postService.deletePost(id).subscribe(() => {
      this.getPages(this.getPagination())
    })
  }

  editPost(id: string) {
    this.router.navigate(['/post', id]);
  }

  createPost() {
    this.router.navigate(['/post']);
  }

  public getPages(event?: PageEvent) {
    const paginationFiler: PaginationFilter = event === null ? null :
      {
        pageNumber: event.pageIndex,
        pageSize: event.pageSize
      };
    this.postService.getPosts(paginationFiler, {}, this.sortFilter).subscribe(
      response => {
        response.items.map(value => {
          value.categoryNames =
            value.categoryModels.map(category => category.name).join(', ');
          value.siteNames =
            value.siteModels.map(site => site.name).join(', ');
          return value;
        });
        this.dataSource = response.items;
        this.dataSource.sort = this.sort;
        this.length = response.totalCount;
        if (event !== null) {
          this.pageIndex = event.pageIndex;
          this.pageSize = event.pageSize;
        }
      }
    );
    return event;
  }

  sortData(event) {
    const paginationFiler: PaginationFilter = event === null ? null :
      {
        pageNumber: this.pageIndex,
        pageSize: this.pageSize,
      };
    const sort = event.active + ',' + event.direction;
    this.sortFilter = sort;

    this.postService.getPosts(paginationFiler, {}, this.sortFilter).subscribe(
      response => {
        response.items.map(value => {
          value.categoryNames =
            value.categoryModels.map(category => category.name).join(', ');
          value.siteNames =
            value.siteModels.map(site => site.name).join(', ');
          return value;
        });
        this.dataSource = response.items;
        this.dataSource.sort = this.sort;
        this.length = response.totalCount;
      }
    );
  }

  logOut() {
    this.loginService.logOut();
    this.router.navigate(['login']);
  }

  clearTitleFiler() {
    this.titleValue='';
    this.titleFilterChanged();
  }
}
