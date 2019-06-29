import { TestBed } from '@angular/core/testing';

import { CadastroPessoaService } from './cadastro-pessoa.service';

describe('CadastroPessoaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CadastroPessoaService = TestBed.get(CadastroPessoaService);
    expect(service).toBeTruthy();
  });
});
