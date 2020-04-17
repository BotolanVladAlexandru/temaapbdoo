import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AuthService, ImportanceService, LocationService, PostService, SiteService} from "../../services";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Category, Importance, Location, Site} from "../../models/Post";

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.scss']
})
export class CreatePostComponent implements OnInit {
  post = new FormGroup({
      title: new FormControl('', Validators.required),
      text: new FormControl('', Validators.required),
      tag: new FormControl('', Validators.required),
      categoryModels: new FormControl([], Validators.required),
      locationModel: new FormControl([], Validators.required),
      importanceModel: new FormControl([], Validators.required),
      siteModels: new FormControl([], Validators.required),
    }
  );


  categories: Category[] = [];
  locations: Location[] = [];
  importances: Importance[] = [];
  sitesList: Site[] = [];

  constructor(private postService: PostService,
              private loginService: AuthService,
              private router: Router,
              private locationService: LocationService,
              private importanceService: ImportanceService,
              private siteService: SiteService) {
  }


  ngOnInit() {

    this.locationService.getLocations().subscribe(value => this.locations = value);
    this.importanceService.getImportance().subscribe(value => this.importances = value);
    this.siteService.getSites().subscribe(value => this.sitesList = value);

    if (!this.loginService.isUserLoggedIn()) {
      this.router.navigate(['login']);
    }
  }

  logOut() {
    this.loginService.logOut();
    this.router.navigate(['login']);
  }

  save() {
    this.postService.createPost(this.post.value).subscribe(() => {
      this.router.navigate(['posts']);
    });
  }

  cancel() {
    this.router.navigate(['posts']);
  }


  onCategoryChanged(categories: Category[]) {
    this.post.get('categoryModels').setValue(categories);
  }

}
