import {
  MatAutocompleteModule,
  MatButtonModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatDividerModule,
  MatFormFieldModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatSelectModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatTreeModule,
} from '@angular/material';
import {NgModule} from '@angular/core';
import {MAT_FORM_FIELD_DEFAULT_OPTIONS} from '@angular/material/form-field';
import {MAT_SELECT_SCROLL_STRATEGY} from '@angular/material/select';
import {BlockScrollStrategy, Overlay} from '@angular/cdk/overlay';
import {MAT_AUTOCOMPLETE_SCROLL_STRATEGY} from '@angular/material/autocomplete';
import {StarRatingModule} from "angular-star-rating";

@NgModule({
  imports: [MatButtonModule, MatCheckboxModule, MatMenuModule, MatToolbarModule, MatIconModule,
    MatDividerModule, MatTableModule, MatFormFieldModule, MatDialogModule, MatInputModule, MatRadioModule,
    MatAutocompleteModule, MatChipsModule, MatCardModule, MatSelectModule, MatGridListModule, MatTreeModule,
    MatSnackBarModule, MatTooltipModule, MatDatepickerModule, MatNativeDateModule, MatPaginatorModule,
    MatSlideToggleModule, MatTabsModule, MatProgressSpinnerModule],
  exports: [MatButtonModule, MatCheckboxModule, MatMenuModule, MatToolbarModule, MatIconModule,
    MatDividerModule, MatTableModule, MatFormFieldModule, MatDialogModule, MatInputModule, MatRadioModule,
    MatAutocompleteModule, MatChipsModule, MatCardModule, MatSelectModule, MatGridListModule, MatTreeModule,
    MatSnackBarModule, MatTooltipModule, MatDatepickerModule, MatNativeDateModule, MatPaginatorModule,
    MatSlideToggleModule, MatTabsModule, MatProgressSpinnerModule ],
  providers: [
    {provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: {appearance: 'outline'}},
    {provide: MAT_SELECT_SCROLL_STRATEGY, useFactory: scrollFactory, deps: [Overlay]},
    {provide: MAT_AUTOCOMPLETE_SCROLL_STRATEGY, useFactory: scrollFactory, deps: [Overlay]}
  ]
})
export class CustomAngularMaterialModule {
}

export function scrollFactory(overlay: Overlay): () => BlockScrollStrategy {
  return () => overlay.scrollStrategies.block();
}
