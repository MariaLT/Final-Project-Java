import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterBookComponent } from './register-book.component';

describe('RegisterBookComponent', () => {
  let component: RegisterBookComponent;
  let fixture: ComponentFixture<RegisterBookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterBookComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
