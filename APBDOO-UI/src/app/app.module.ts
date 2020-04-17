import {BrowserModule, HAMMER_GESTURE_CONFIG} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import * as services from './services';
import * as fromContainers from './containers';

import {AppRouterModule} from "./app.router.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClientModule} from "@angular/common/http";
import {CustomAngularMaterialModule} from "./custom-angular-material.module";
import {GestureConfig} from "@angular/material/core";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {StarRatingModule} from "angular-star-rating";
import {MatSortModule} from "@angular/material/sort";

@NgModule({
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,

    // Router config
    AppRouterModule,

    // Project specific modules
    CustomAngularMaterialModule,
    ReactiveFormsModule,
    MatSortModule,
    FormsModule,
  ],
  providers: [
    ...services.services,
    {provide: HAMMER_GESTURE_CONFIG, useClass: GestureConfig},
  ],
  declarations: [...fromContainers.containers],
  bootstrap: [fromContainers.AppRootComponent]
})
export class AppModule {
}
