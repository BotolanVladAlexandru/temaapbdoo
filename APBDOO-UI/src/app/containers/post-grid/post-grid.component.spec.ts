import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageGridd } from './post-grid.component';

describe('AppRootComponent', () => {
  let component: PageGridd;
  let fixture: ComponentFixture<PageGridd>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageGridd ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageGridd);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
