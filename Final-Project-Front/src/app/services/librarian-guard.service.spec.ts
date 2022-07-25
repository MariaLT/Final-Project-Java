import { TestBed } from '@angular/core/testing';

import { LibrarianGuardService } from './librarian-guard.service';

describe('LibrarianGuardService', () => {
  let service: LibrarianGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LibrarianGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
