import { TestBed } from '@angular/core/testing';

import { CadastrarIngredienteService } from './cadastrar-ingrediente.service';

describe('CadastrarIngredienteService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CadastrarIngredienteService = TestBed.get(CadastrarIngredienteService);
    expect(service).toBeTruthy();
  });
});
