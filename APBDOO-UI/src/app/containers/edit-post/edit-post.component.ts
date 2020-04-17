import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService, ImportanceService, LocationService, PostService, SiteService} from "../../services";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Category, Importance, Location, Site} from "../../models/Post";

@Component({
  selector: 'app-edit-post',
  templateUrl: './edit-post.component.html',
  styleUrls: ['./edit-post.component.scss']
})
export class EditPostComponent implements OnInit {
  id: string;
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

  constructor(private router: Router,
              private route: ActivatedRoute,
              private postService: PostService,
              private loginService: AuthService,
              private locationService: LocationService,
              private importanceService: ImportanceService,
              private siteService: SiteService) {
  }

  ngOnInit() {
    if (!this.loginService.isUserLoggedIn()) {
      this.router.navigate(['login']);
    }
    this.id = this.route.snapshot.params['id'];
    this.siteService.getSites().subscribe(sites => {
      this.sitesList = sites;
      this.importanceService.getImportance().subscribe(importances => {
        this.importances = importances;
        this.locationService.getLocations().subscribe(locations => {
          this.locations = locations;
          this.postService.getPost(this.id).subscribe((value => {
              this.post.get('title').setValue(value.title);
              this.post.get('text').setValue(value.text);
              this.post.get('tag').setValue(value.tagModel.name);
              this.post.get('categoryModels').setValue(value.categoryModels);
              this.post.get('locationModel').setValue(this.locations.filter(loc => loc.id === value.locationModel.id)[0]);
              this.post.get('importanceModel').setValue(this.importances.filter(im => im.id === value.importanceModel.id)[0]);
              this.post.get('siteModels').setValue(this.sitesList.filter(site => value.siteModels.map(s => s.id).includes(site.id)));
              this.categories = value.categoryModels;
            }
          ));
        });
      });
    });
  }

  logOut() {
    this.loginService.logOut();
    this.router.navigate(['login']);
  }

  save() {
    this.postService.updatePost(this.id, this.post.value).subscribe(() => {
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
