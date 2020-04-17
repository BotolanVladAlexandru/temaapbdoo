import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {COMMA, ENTER} from "@angular/cdk/keycodes";
import {MatChipInputEvent} from "@angular/material/chips";
import {Category} from "../../models/Post";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-chip-input',
  templateUrl: './chip-input.component.html',
  styleUrls: ['./chip-input.component.scss']
})
export class ChipInputComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

  inputChipForm = new FormGroup({
      inputChip: new FormControl([], Validators.required),
    }
  );

  selectable = true;
  removable = true;
  addOnBlur = true;

  @Input() placeholder;
  readonly separatorKeysCodes: number[] = [ENTER, COMMA];

  @Input() categories = [];
  @Output() onCategoryChanged: EventEmitter<Category[]> = new EventEmitter<Category[]>();

  add(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;

    // Add our category
    if ((value || '').trim()) {
      this.categories.push({name: value.trim()});
    }

    // Reset the input value
    if (input) {
      input.value = '';
    }
    this.inputChipForm.get('inputChip').setValue(this.categories);

    this.onCategoryChanged.emit(this.categories);
  }

  remove(category: Category): void {
    const index = this.categories.indexOf(category);

    if (index >= 0) {
      this.categories.splice(index, 1);
    }

    this.inputChipForm.get('inputChip').setValue(this.categories);
    this.onCategoryChanged.emit(this.categories);
  }
}
