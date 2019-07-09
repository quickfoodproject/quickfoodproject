import { TestBed } from '@angular/core/testing';

import { CadastrarReceitaService } from './cadastrar-receita.service';

describe('CadastrarReceitaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CadastrarReceitaService = TestBed.get(CadastrarReceitaService);
    expect(service).toBeTruthy();
  });
});
