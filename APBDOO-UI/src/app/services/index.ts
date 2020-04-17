import {PostService} from "./post.service";
import {AuthService} from "./auth.service";
import {LocationService} from "./location.service";
import {SiteService} from "./site.service";
import {ImportanceService} from "./importance.service";

export const services: any[] = [
  PostService,
  AuthService,
  LocationService,
  SiteService,
  ImportanceService
];

export * from './post.service';
export * from "./auth.service";
export * from "./location.service";
export * from "./site.service";
export * from "./importance.service";
