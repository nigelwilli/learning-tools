import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieTitleComponent } from './movie-title.component';

describe('MovieTitleComponent', () => {
  let component: MovieTitleComponent;
  let fixture: ComponentFixture<MovieTitleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieTitleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieTitleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
