import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrarianHomeComponent } from './librarian-home.component';

describe('LibrarianHomeComponent', () => {
  let component: LibrarianHomeComponent;
  let fixture: ComponentFixture<LibrarianHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibrarianHomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibrarianHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
